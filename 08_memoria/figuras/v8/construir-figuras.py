"""Figuras nuevas del borrador v8 de la memoria de Relevo (segunda versión, 21 de noviembre de 2026).

Cada figura se diseña a su tamaño real en la memoria de 1920 × 1080 pt: una columna (551 pt), dos columnas
(1146 pt) o el ancho del texto (1742 pt). Así se colocan al 100 %, sin escalar, y su letra es la de las demás
figuras de la memoria, medida en el PDF del Pase: 20,6 pt en el texto de las figuras y 19,9 pt en los rótulos,
nunca menos. Los íconos son los de la app 4.8.2, desde Lucide (marca-e-iconos.json), de 30 a 40 pt; los números van sueltos,
sin círculos, como pidió el autor el 10 de noviembre.

Desde la tercera vuelta (21 de noviembre, a pedido del autor) son diagramas simples —líneas, puntos, flechas y
texto—, sin cajas que no expliquen nada, y el color lleva degradados sutiles, como los de la app: tres tonos
vecinos de la misma luminosidad para las superficies y, en las barras, del tono claro al intenso de su color.

Chrome convierte cada figura en un PDF vectorial (para Affinity), pdftocairo en un SVG (para el generador de la
memoria) y en un PNG para verla en el repositorio. Las medidas quedan en medidas.json. Las figuras no llevan título
ni nota: los pone la memoria, en APA 7.

Uso, desde esta carpeta: python3 construir-figuras.py [clave ...]
"""
import json
import os
import re
import subprocess
import sys

AQUI = os.path.dirname(os.path.abspath(__file__))
LETRA = '../../memoria-1920x1080/letra/estaticas'  # relativa a esta carpeta, donde quedan los HTML
ICONOS = json.load(open(os.path.join(AQUI, '..', '..', 'memoria-1920x1080', 'marca-e-iconos.json'), encoding='utf-8'))['icons']
CHROME = '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome'

TINTA, GRIS, LINEA, PAPEL = '#141312', '#6E6964', '#E4DED6', '#F7F4F0'
LUZ = {'Neutro': '#ECE7E0', 'Amarillo': '#F4E496', 'Cielo': '#B3E5FC', 'Lima': '#C6EEAE', 'Rubor': '#FAC8D9', 'Lila': '#DFD1FC', 'Durazno': '#FBD1B3'}
# Degradados sutiles, como los anillos de la app (Sky.ring): tres tonos vecinos de cada papel, de una luminosidad
# parecida, para que el color se vea vivo sin cambiar de peso. Las barras van del papel al tono intenso de la
# identidad (Figura «Sistema de identidad»), como una barra que se llena.
DEGRADE = {
    'Amarillo': ('#FBF0C0', '#F4E496', '#F6D9A0'),
    'Cielo': ('#D9F2FE', '#B3E5FC', '#BCD9FA'),
    'Lima': ('#E3F6D6', '#C6EEAE', '#BDE8C2'),
    'Rubor': ('#FDE3EC', '#FAC8D9', '#EEC9EC'),
    'Lila': ('#EEE7FE', '#DFD1FC', '#D2D8FB'),
    'Durazno': ('#FDE7D6', '#FBD1B3', '#F9C9C2'),
    'Neutro': ('#F5F1EB', '#ECE7E0', '#E5DFD7'),
}
INTENSO = {'Amarillo': '#FFD54A', 'Cielo': '#9DD6F4', 'Lima': '#B3E788', 'Rubor': '#F6A3CB', 'Lila': '#C5B2F6', 'Durazno': '#F9B68A'}


def grad(color, ang=135):
    # Dos tonos (el claro y el vecino): con tres, pdftocairo convierte el degradado en una imagen al pasarlo a SVG.
    luz = DEGRADE[color]
    return f'linear-gradient({ang}deg,{luz[0]},{luz[2]})'


# Anchos de la memoria (pt): una columna, dos columnas con su medianil y el ancho del texto.
COL, DOBLE, ANCHO = 550.9, 1146.4, 1741.8


def icono(nombre, tam=34, color=TINTA, grosor=1.7):
    return (f'<svg class="ic" viewBox="0 0 24 24" width="{tam}pt" height="{tam}pt" style="color:{color}" fill="none" '
            f'stroke="currentColor" stroke-width="{grosor}" stroke-linecap="round" stroke-linejoin="round">{ICONOS[nombre]}</svg>')


def cuadro(nombre, color, tam=60, ic=34):
    """Un ícono sobre un círculo con el degradado de su color (sin cajas)."""
    return f'<div class="cuad" style="width:{tam}pt;height:{tam}pt;border-radius:50%;background:{grad(color)}">{icono(nombre, ic)}</div>'


def punto(color, tam=26):
    fondo = f'linear-gradient(135deg,{DEGRADE[color][0]},{INTENSO[color]})' if color in INTENSO else grad(color)
    return f'<span class="pto" style="width:{tam}pt;height:{tam}pt;background:{fondo}"></span>'


def flecha(largo=40, vertical=False, color=TINTA, grosor=2.4):
    a = 22
    if vertical:
        return (f'<svg class="fl" width="{a}pt" height="{largo}pt" viewBox="0 0 {a} {largo}"><path d="M{a/2} 1.5V{largo-2.5}'
                f'M{a/2-7} {largo-10}L{a/2} {largo-2.5}L{a/2+7} {largo-10}" fill="none" stroke="{color}" stroke-width="{grosor}" '
                f'stroke-linecap="round" stroke-linejoin="round"/></svg>')
    return (f'<svg class="fl" width="{largo}pt" height="{a}pt" viewBox="0 0 {largo} {a}"><path d="M1.5 {a/2}H{largo-2.5}'
            f'M{largo-10} {a/2-7}L{largo-2.5} {a/2}L{largo-10} {a/2+7}" fill="none" stroke="{color}" stroke-width="{grosor}" '
            f'stroke-linecap="round" stroke-linejoin="round"/></svg>')


CSS = f"""
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Regular.ttf');font-weight:400}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Medium.ttf');font-weight:500}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-SemiBold.ttf');font-weight:600}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Italic.ttf');font-style:italic}}
*{{box-sizing:border-box;margin:0;padding:0;background-repeat:no-repeat !important;background-size:100% 100% !important}}  /* sin repetir: Chrome dibuja el degradado como vector, no como imagen */
html,body{{background:transparent;-webkit-print-color-adjust:exact;print-color-adjust:exact}}
body{{font-family:'IS';color:{TINTA};font-size:20.6pt;line-height:28pt;font-feature-settings:'kern';-webkit-font-smoothing:antialiased}}
.ficha{{background:#fff;border-radius:26.7pt;padding:26.7pt;position:relative}}
.ficha.col{{padding:22.3pt}}
.sb{{font-weight:600}} .gris{{color:{GRIS}}}
.cab{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS}}}
.tit{{font-size:23pt;line-height:30pt;font-weight:600}}
.ic{{display:block;flex:none}} .fl{{display:block;flex:none;overflow:visible}}
.cuad{{display:flex;align-items:center;justify-content:center;flex:none}}
.n{{font-weight:600;font-feature-settings:'tnum'}}
.pto{{display:block;flex:none;border-radius:50%}}
svg.capa{{position:absolute;left:0;top:0;width:100%;height:100%;overflow:visible;pointer-events:none}}
"""

MEDIR = """<script>document.fonts.ready.then(()=>{setTimeout(()=>{const f=document.querySelector('.ficha');
document.documentElement.setAttribute('data-alto',Math.ceil(f.getBoundingClientRect().height*0.75)+1);},50);});</script>"""

# Ayuda para dibujar conectores con las posiciones reales, una vez cargada la letra: r(id) da el rectángulo de un
# elemento en pt, relativo a la ficha; capa() devuelve el SVG de conectores de la ficha.
JS_BASE = """<script>
const PX=0.75;
function r(id){const f=document.querySelector('.ficha').getBoundingClientRect(),e=document.getElementById(id).getBoundingClientRect();
return {x:(e.left-f.left)*PX,y:(e.top-f.top)*PX,w:e.width*PX,h:e.height*PX,get cx(){return this.x+this.w/2},get cy(){return this.y+this.h/2},get b(){return this.y+this.h},get d(){return this.x+this.w}};}
function capa(){const f=document.querySelector('.ficha'),b=f.getBoundingClientRect();let s=f.querySelector('svg.capa');
if(!s){s=document.createElementNS('http://www.w3.org/2000/svg','svg');s.setAttribute('class','capa');f.appendChild(s);}
s.setAttribute('viewBox',`0 0 ${b.width*PX} ${b.height*PX}`);return s;}
const T='#141312';
function trazo(d,g=2.4){return `<path d="${d}" fill="none" stroke="${T}" stroke-width="${g}" stroke-linecap="round" stroke-linejoin="round"/>`;}
function punta(x,y,dir,g=2.4){const k=8.5;const d={d:`M${x-k} ${y-k*.85}L${x} ${y}L${x-k} ${y+k*.85}`,i:`M${x+k} ${y-k*.85}L${x} ${y}L${x+k} ${y+k*.85}`,
a:`M${x-k*.85} ${y+k}L${x} ${y}L${x+k*.85} ${y+k}`,b:`M${x-k*.85} ${y-k}L${x} ${y}L${x+k*.85} ${y-k}`}[dir];return trazo(d,g);}
</script>"""


def pagina(cuerpo, ancho, alto, css_extra='', js='', medir=False, titulo='Figura de Relevo'):
    tam = f'@page{{size:{ancho}pt {alto}pt;margin:0}} body{{width:{ancho}pt;height:{alto}pt}}' if alto else f'body{{width:{ancho}pt}}'
    dibujo = f'{JS_BASE}<script>document.fonts.ready.then(()=>{{{js}}});</script>' if js else ''
    return (f'<!doctype html><html lang="es"><head><meta charset="utf-8"><title>{titulo}</title><style>{CSS}{css_extra}{tam}</style></head>'
            f'<body>{cuerpo}{dibujo}{MEDIR if medir else ""}</body></html>')


BASE = [CHROME, '--headless=new', '--disable-gpu', '--hide-scrollbars', '--no-sandbox', '--allow-file-access-from-files']


def alto_de(cuerpo, ancho, css, js):
    """Primera pasada: mide el alto de la ficha con la tipografía cargada."""
    ruta = os.path.join(AQUI, '_medir.html')
    open(ruta, 'w', encoding='utf-8').write(pagina(cuerpo, ancho, None, css, js, medir=True))
    dom = subprocess.run(BASE + ['--virtual-time-budget=5000', f'--window-size={round(ancho*4/3)},3000', '--dump-dom', 'file://' + ruta],
                         capture_output=True, text=True).stdout
    os.remove(ruta)
    m = re.search(r'data-alto="(\d+)"', dom)
    if not m:
        raise SystemExit('no se pudo medir la figura')
    return int(m.group(1))


def generar(nombre, cuerpo, css, ancho, js=''):
    alto = alto_de(cuerpo, ancho, css, js)
    ruta = os.path.join(AQUI, nombre + '.html')
    open(ruta, 'w', encoding='utf-8').write(pagina(cuerpo, ancho, alto, css, js, titulo=TITULOS.get(nombre, 'Figura de Relevo')))
    pdf, svg, png = (os.path.join(AQUI, nombre + e) for e in ('.pdf', '.svg', '.png'))
    subprocess.run(BASE + ['--no-pdf-header-footer', '--virtual-time-budget=5000', f'--print-to-pdf={pdf}', 'file://' + ruta],
                   check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    subprocess.run(['pdftocairo', '-svg', pdf, svg], check=True)
    subprocess.run(['pdftocairo', '-png', '-singlefile', '-r', '144', pdf, png[:-4]], check=True)
    medidas = json.load(open(os.path.join(AQUI, 'medidas.json'), encoding='utf-8')) if os.path.exists(os.path.join(AQUI, 'medidas.json')) else {}
    medidas[nombre] = {'ancho': ancho, 'alto': alto}
    json.dump(dict(sorted(medidas.items())), open(os.path.join(AQUI, 'medidas.json'), 'w', encoding='utf-8'), indent=1, ensure_ascii=False)
    print(f'listo: {nombre} ({ancho} × {alto} pt)')


FIGURAS = {}
TITULOS = {
    'figura-v8-framework': 'Análisis de las entrevistas con el método Framework',
    'figura-v8-formulacion': 'Cadena de la formulación, del problema a las conclusiones',
    'figura-v8-metodo': 'Método del proyecto, de la investigación a la iteración',
    'figura-v8-estados': 'Estados de un relevo',
    'figura-v8-sistema': 'Cómo funciona Relevo: la persona, la aplicación y el objeto',
    'figura-v8-registro': 'Qué se registró en cada relevo',
    'figura-v8-comparacion': 'Comparación propuesta para la etapa siguiente',
}


def figura(clave):
    def reg(f):
        FIGURAS[clave] = f
        return f
    return reg


# =============================================================== Figura 6 · Método Framework (dos columnas)
@figura('framework')
def framework():
    """Arriba, los cinco momentos del método. Al centro, la matriz: una fila por persona y una columna por tema, como en
    el Anexo A. Abajo, las dos maneras de leerla —una fila o una columna— y lo que salió de ellas: dos tipos ideales.
    La matriz va sin datos ni destacados, para que ninguna persona parezca más importante que otra."""
    momentos = [('Familiarización', 'Leer las ocho transcripciones'),
                ('Marco analítico', 'Temas previos y temas nuevos'),
                ('Indexación', 'Asignar un tema a cada fragmento'),
                ('Matriz', 'Resumir por persona y por tema'),
                ('Interpretación', 'Leer la matriz de dos maneras')]
    temas = ['Decidida o automática', 'Percepción del tiempo', 'Recuerdo', 'Alternativa valorada', 'Conflicto posterior',
             'Contexto', 'Estrategias previas', 'Intervención física', 'Autonomía']
    pasos = ''.join(f'<div class="paso"><div class="pc"><span class="n">{k + 1}</span><span class="sb">{t}</span></div><div class="gris">{d}</div></div>'
                    + (f'<div class="sep">{flecha(24)}</div>' if k < 4 else '') for k, (t, d) in enumerate(momentos))
    g = '<div></div>' + ''.join(f'<div class="th">{t}</div>' for t in temas)
    for p in range(1, 9):
        g += f'<div class="pr">P{p}</div>' + '<div class="c"></div>' * len(temas)

    def mini(destaca):
        celdas = ''
        for f in range(4):
            for c in range(6):
                on = (destaca == 'fila' and f == 1) or (destaca == 'columna' and c == 2)
                celdas += f'<i class="{"on " + destaca if on else ""}"></i>'
        return f'<div class="mini">{celdas}</div>'
    lecturas = ('<div class="lecturas">'
                f'<div class="lec">{mini("fila")}<div><div class="sb">Por persona</div><div class="gris">Cada fila es un caso completo</div></div></div>'
                f'<div class="lec">{mini("columna")}<div><div class="sb">Por tema</div><div class="gris">Cada columna muestra lo que se repite</div></div></div>'
                '</div>')
    resultado = (f'<div class="baja">{flecha(30, vertical=True)}<span class="sb">Dos tipos ideales</span><span class="gris">Situaciones que reúnen casos parecidos</span></div>'
                 '<div class="tipos">'
                 f'<div class="tipo">{punto("Rubor", 26)}<div><div class="sb">Usuario principal</div><div class="gris">La sesión sigue sin una nueva decisión y otra actividad deja de estar presente</div></div></div>'
                 f'<div class="tipo">{punto("Lima", 26)}<div><div class="sb">Usuario límite</div><div class="gris">El ocio digital conserva sentido o no hay otra intención: no corresponde intervenir</div></div></div>'
                 '</div>')
    css = f"""
    .pasos{{display:flex;align-items:flex-start;margin-bottom:26pt}}
    .paso{{flex:1;display:flex;flex-direction:column;gap:3pt}} .pc{{display:flex;gap:8pt;align-items:baseline;white-space:nowrap}} .pc .n{{color:{GRIS}}}
    .sep{{padding:0 8pt;margin-top:3pt}}
    .mz{{display:grid;grid-template-columns:40pt repeat({len(temas)},1fr);column-gap:6pt;row-gap:5pt;align-items:end}}
    .th{{font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS};padding-bottom:6pt}}
    .pr{{font-size:19.9pt;line-height:22pt;font-weight:600;color:{GRIS};align-self:center}}
    .c{{height:21pt;border-radius:6pt;background:{PAPEL}}}
    .lecturas{{display:grid;grid-template-columns:1fr 1fr;column-gap:36pt;margin-top:24pt;padding-top:20pt;border-top:1.4pt solid {LINEA}}}
    .lec{{display:flex;gap:20pt;align-items:center}}
    .mini{{display:grid;grid-template-columns:repeat(6,13pt);grid-auto-rows:10pt;gap:3pt;flex:none}}
    .mini i{{display:block;border-radius:2.5pt;background:#EAE5DE}}
    .mini i.on.fila{{background:{grad('Cielo', 90)}}} .mini i.on.columna{{background:{grad('Amarillo', 180)}}}
    .baja{{display:flex;align-items:center;gap:12pt;margin:20pt 0 12pt}} .baja .gris{{margin-left:4pt}}
    .tipos{{display:grid;grid-template-columns:1fr 1fr;column-gap:36pt}}
    .tipo{{display:flex;gap:14pt;align-items:flex-start}} .tipo .pto{{margin-top:1pt}}
    """
    cuerpo = f'<div class="ficha"><div class="pasos">{pasos}</div><div class="mz">{g}</div>{lecturas}{resultado}</div>'
    return 'figura-v8-framework', cuerpo, css, DOBLE, ''


# =============================================================== Figura 13 · Cadena de la formulación (dos columnas)
@figura('formulacion')
def formulacion():
    """Seis puntos unidos por flechas, que se leen hacia abajo: del problema a las conclusiones. Debajo, en una oración,
    cómo se lee al revés."""
    filas = [
        ('Lila', 'Problema', 'Ayudar a que una intención propia vuelva a tiempo con el teléfono libre y la decisión en manos de la persona.'),
        ('Cielo', 'Pregunta', '¿Cuál es el efecto de un sistema <i>phygital</i> que vincula una actividad pendiente con su lugar de inicio sobre el recuerdo oportuno de esa actividad durante el ocio digital?'),
        ('Amarillo', 'Hipótesis', 'Si el sistema vincula la actividad con el lugar donde comienza, la persona la recordará a tiempo. Supuestos: asociación, decisión y soporte.'),
        ('Lima', 'Objetivos', 'Entender el problema. Diseñar el sistema. Compararlo con una notificación. Medir en hogares el recuerdo oportuno.'),
        ('Durazno', 'Prueba', 'Tres hogares durante cinco semanas. Tras cada señal: ¿supo qué quería hacer antes de mirar la pantalla? ¿Recordó cómo empezar? ¿Qué decidió?'),
        ('Rubor', 'Conclusiones', 'El ciclo funciona en tres hogares. Aún no se puede afirmar que el objeto supere a la notificación ni que el lugar sea lo que ayuda.'),
    ]
    g = ''.join(f'<div class="et"><span id="p{k}">{punto(color, 28)}</span><span class="tit">{nombre}</span></div><div class="tx">{texto}</div>'
                for k, (color, nombre, texto) in enumerate(filas))
    reves = ('<div class="reves"><div></div><div><span class="sb">Al revés también se sostiene.</span> Las conclusiones responden la pregunta '
             'y la prueba mide el recuerdo oportuno que anticipa la hipótesis.</div></div>')
    css = f"""
    .esc,.reves{{display:grid;grid-template-columns:232pt 1fr}}
    .esc{{row-gap:24pt;align-items:center}}
    .et{{display:flex;align-items:center;gap:18pt}}
    .reves{{margin-top:28pt;padding-top:20pt;border-top:1.4pt solid {LINEA};color:{GRIS}}} .reves .sb{{color:{TINTA}}}
    """
    # Entre cada par de puntos, una flecha hacia abajo: el sentido de lectura.
    js = """
    const s=capa();let h='';
    for(let k=0;k<5;k++){const p=r('p'+k),q=r('p'+(k+1));h+=trazo(`M${p.cx} ${p.b+6}V${q.y-7}`,2.2)+punta(p.cx,q.y-7,'b',2.2);}
    s.innerHTML=h;
    """
    cuerpo = f'<div class="ficha"><div class="esc">{g}</div>{reves}</div>'
    return 'figura-v8-formulacion', cuerpo, css, DOBLE, js


# =============================================================== Figura 14 · Método del proyecto (una columna)
@figura('metodo')
def metodo():
    """Las cuatro fuentes llevan a una línea de cinco etapas, unidas por flechas. A la derecha, un bucle vuelve de los
    cambios al diseño: la iteración. El bucle sale y llega a la altura del nombre de cada etapa."""
    fuentes = [('leer', 'Revisión bibliográfica'), ('entrevistas', 'Ocho entrevistas'),
               ('datos', 'Encuesta de 53 respuestas'), ('buscar', 'Estado del arte')]
    etapas = [('Rubor', 'Criterios', 'Ocho criterios de diseño'),
              ('Durazno', 'Diseño', 'La aplicación y el objeto'),
              ('Cielo', 'Prueba', 'Tres hogares durante cinco semanas'),
              ('Amarillo', 'Hallazgos', 'Lo que hicieron las personas y no solo lo que dijeron'),
              ('Lima', 'Cambios', 'Nueve cambios en la aplicación')]
    fu = ''.join(f'<div class="fu">{icono(i, 30, GRIS)}<span>{t}</span></div>' for i, t in fuentes)
    et = ''.join(f'<div class="et" id="e{k}"><span id="p{k}">{punto(c, 28)}</span><div class="etx"><div><span class="sb" id="t{k}">{t}</span></div><div class="gris">{d}</div></div></div>'
                 for k, (c, t, d) in enumerate(etapas))
    css = f"""
    .cab{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS};margin-bottom:10pt}}
    .fus{{display:grid;row-gap:8pt;padding-bottom:16pt;border-bottom:2.4pt solid {TINTA}}}
    .fu{{display:flex;align-items:center;gap:14pt}}
    .ets{{display:grid;row-gap:26pt;padding-top:38pt}}
    .et{{display:flex;gap:18pt;align-items:flex-start}}
    .etx{{max-width:350pt}}
    .iterar{{position:absolute;font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS}}}
    """
    js = """
    const s=capa();let h='';
    for(let k=0;k<4;k++){const p=r('p'+k),q=r('p'+(k+1));h+=trazo(`M${p.cx} ${p.b+6}V${q.y-7}`,2.2)+punta(p.cx,q.y-7,'b',2.2);}
    const fi=document.querySelector('.ficha').getBoundingClientRect(),raya=document.querySelector('.fus').getBoundingClientRect();
    const a=r('p0'),yr=(raya.bottom-fi.top)*PX;h+=trazo(`M${a.cx} ${yr+6}V${a.y-7}`,2.2)+punta(a.cx,a.y-7,'b',2.2);
    // Bucle: de «Cambios» vuelve a «Diseño», por la derecha, a la altura de cada nombre.
    const W=fi.width*PX,xb=W-22.3-10,t1=r('t1'),t4=r('t4'),y1=r('p1').cy,y4=r('p4').cy;
    h+=trazo(`M${t4.d+16} ${y4}H${xb-14}Q${xb} ${y4} ${xb} ${y4-14}V${y1+14}Q${xb} ${y1} ${xb-14} ${y1}H${t1.d+16}`,2.2)+punta(t1.d+15,y1,'i',2.2);
    s.innerHTML=h;
    // «Iterar» va junto a la línea, en el espacio entre «Prueba» y «Hallazgos».
    const it=document.getElementById('iterar'),ib=it.getBoundingClientRect(),e2=r('e2'),e3=r('e3');
    it.style.left=(xb-12-ib.width*PX)+'pt';it.style.top=((e2.b+e3.y)/2-ib.height*PX/2)+'pt';
    """
    cuerpo = (f'<div class="ficha col"><div class="cab">Fuentes</div><div class="fus">{fu}</div><div class="ets">{et}</div>'
              '<div class="iterar" id="iterar">Iterar</div></div>')
    return 'figura-v8-metodo', cuerpo, css, COL, js


# =============================================================== Figura 18 · Estados de un relevo (ancho completo)
@figura('estados')
def estados():
    """El ciclo de un relevo de izquierda a derecha, en los seis estados del Anexo G. Sobre cada flecha, lo que la hace
    avanzar. Tres caminos más, cada uno con su rótulo sobre su propia línea: editar devuelve un relevo en espera al
    borrador y responder sin silenciar cierra uno que suena (arriba); desactivarlo o eliminarlo lo cierra mientras
    espera (abajo)."""
    orden = [('borrador', 'Borrador', 'Lila', 'editar'), ('listo', 'Listo', 'Cielo', 'listo'),
             ('espera', 'En espera', 'Amarillo', 'esperando'), ('sonando', 'Sonando', 'Durazno', 'suena'),
             ('silenciado', 'Silenciado', 'Neutro', 'silenciar'), ('cerrado', 'Cerrado', 'Rubor', 'decidir')]
    pasos = ['Completa los datos', 'Activa el relevo', 'Se cumple el tiempo', 'Lo silencia', 'Responde']
    nodos = ''.join(f'<div class="st" id="{k}" style="background:{grad(c, 100)}">{icono(ic, 28)}<span class="tit">{t}</span></div>' for k, t, c, ic in orden)
    fila = f'<div class="fila" id="fila"><span class="ini" id="ini"></span><div class="sts">{nodos}</div><span class="fin" id="fin"></span></div>'
    rots = ''.join(f'<div class="rt" id="r{k}">{t}</div>' for k, t in enumerate(pasos))
    rots += ''.join(f'<div class="rt" id="{i}">{t}</div>' for i, t in (('ra', 'Lo edita'), ('rc', 'Responde sin silenciar'), ('rb', 'Lo desactiva o elimina')))
    css = f"""
    .lienzo{{position:relative;width:100%}}
    .fila{{position:absolute;left:0;right:0;display:flex;align-items:center}}
    .sts{{flex:1;display:flex;justify-content:space-between;margin:0 58pt}}
    .st{{display:flex;align-items:center;gap:10pt;height:54pt;padding:0 20pt 0 18pt;border-radius:999pt}}
    .st .tit{{font-size:21.5pt;white-space:nowrap}}
    .ini{{width:18pt;height:18pt;border-radius:50%;background:{TINTA};flex:none}}
    .fin{{width:24pt;height:24pt;border-radius:50%;border:2.2pt solid {TINTA};flex:none;position:relative}}
    .fin::after{{content:'';position:absolute;left:4.8pt;top:4.8pt;width:10pt;height:10pt;border-radius:50%;background:{TINTA}}}
    .rt{{position:absolute;color:{GRIS};white-space:nowrap;line-height:25pt}}
    """
    js = """
    const L=document.querySelector('.lienzo'),F=document.getElementById('fila');
    const ids=['borrador','listo','espera','sonando','silenciado','cerrado'];
    const g=x=>document.getElementById(x),tam=e=>{const b=e.getBoundingClientRect();return {w:b.width*PX,h:b.height*PX};};
    // Todo se calcula en pt, relativo a la ficha; los rótulos se colocan relativos al lienzo.
    const fb=document.querySelector('.ficha').getBoundingClientRect(),lb=L.getBoundingClientRect();
    const ox=(lb.left-fb.left)*PX,oy=(lb.top-fb.top)*PX;
    const pon=(e,x,y)=>{e.style.left=(x-ox)+'pt';e.style.top=(y-oy)+'pt';},centro=(e,x,y)=>pon(e,x-tam(e).w/2,y);
    // De arriba abajo: rótulos de los caminos de arriba, sus líneas, rótulos de las flechas, la fila; abajo, un camino y su rótulo.
    const hr=tam(g('r0')).h,h2=27,Y0=oy+hr+8+16+hr+10+h2;
    F.style.top=(Y0-h2-oy)+'pt';
    const p={};ids.forEach(k=>p[k]=r(k));
    for(let k=0;k<5;k++){const a=p[ids[k]],b=p[ids[k+1]];centro(g('r'+k),(a.d+b.x)/2,Y0-h2-10-hr);}
    const ya=Y0-h2-10-hr-16,yb=Y0+h2+30,R=14,ini=r('ini'),fin=r('fin');
    let h=trazo(`M${ini.d+5} ${Y0}H${p.borrador.x-7}`,2.2)+punta(p.borrador.x-7,Y0,'d',2.2);
    for(let k=0;k<5;k++){const a=p[ids[k]],b=p[ids[k+1]];h+=trazo(`M${a.d+7} ${Y0}H${b.x-7}`,2.2)+punta(b.x-7,Y0,'d',2.2);}
    h+=trazo(`M${p.cerrado.d+7} ${Y0}H${fin.x-6}`,2.2)+punta(fin.x-6,Y0,'d',2.2);
    const arco=(x1,x2,y,arriba)=>{const s=x2>x1?1:-1,v=arriba?1:-1,y0=arriba?Y0-h2-6:Y0+h2+6,y1=arriba?Y0-h2-7:Y0+h2+7;
      return trazo(`M${x1} ${y0}V${y+R*v}Q${x1} ${y} ${x1+R*s} ${y}H${x2-R*s}Q${x2} ${y} ${x2} ${y+R*v}V${y1}`,2.2)+punta(x2,y1,arriba?'b':'a',2.2);};
    h+=arco(p.espera.cx,p.borrador.cx,ya,true)+arco(p.sonando.cx,p.cerrado.cx,ya,true)+arco(p.espera.cx,p.cerrado.cx,yb,false);
    centro(g('ra'),(p.espera.cx+p.borrador.cx)/2,ya-8-hr);
    centro(g('rc'),(p.sonando.cx+p.cerrado.cx)/2,ya-8-hr);
    centro(g('rb'),(p.espera.cx+p.cerrado.cx)/2,yb+8);
    L.style.height=(yb+8+hr+2-oy)+'pt';
    const s=capa();s.innerHTML=h;
    """
    cuerpo = f'<div class="ficha"><div class="lienzo">{fila}{rots}</div></div>'
    return 'figura-v8-estados', cuerpo, css, ANCHO, js


# =============================================================== Figura 26 · Cómo funciona Relevo (dos columnas)
@figura('sistema')
def sistema():
    """Tres carriles —la persona, la aplicación y el Tag— en los cuatro momentos del recorrido. Entre los carriles, las
    órdenes que viajan de uno a otro. Cada carril es una franja del color de su actor, que se desvanece hacia la
    derecha; el texto va sin cajas."""
    momentos = ['Preparar', 'Seguir en el teléfono', 'Oír la señal', 'Decidir']
    persona = ['Anota la actividad y ubica el Tag', 'Usa el teléfono como siempre',
               'Oye la señal desde el lugar de la actividad', 'Responde qué decidió']
    app = ['Guarda el relevo', 'Suma el tiempo de las apps elegidas', 'Suena el teléfono si el Tag no responde', 'Guarda la respuesta']
    tag = ['Queda junto al primer paso', 'Espera. El teléfono lo busca antes de sonar', 'Suena unos 30 segundos', '']

    def carril(ic, color, nombre, celdas):
        luz = DEGRADE[color]
        out = (f'<div class="franja" style="background:linear-gradient(90deg,{luz[1]},#FFFFFF)">'
               f'<div class="lab">{icono(ic, 32)}<span class="sb">{nombre}</span></div>')
        return out + ''.join(f'<div class="celda">{c}</div>' for c in celdas) + '</div>'

    def enlace(textos):
        return '<div class="enlaces"><div></div>' + ''.join(
            f'<div class="enl">{flecha(26, vertical=True)}<span>{t}</span></div>' if t else '<div></div>' for t in textos) + '</div>'

    cab = '<div class="cabs"><div></div>' + ''.join(f'<div class="mom"><span class="n gris">{k + 1}</span><span class="sb">{t}</span></div>' for k, t in enumerate(momentos)) + '</div>'
    g = (cab + carril('usuario', 'Rubor', 'Persona', persona) + enlace(['prepara', '', '', 'responde'])
         + carril('telefono', 'Cielo', 'Aplicación', app) + enlace(['prueba el sonido', '', 'ordena sonar', ''])
         + carril('tag', 'Lima', 'Tag', tag))
    css = f"""
    .ficha{{padding:22pt 26.7pt}}
    .cabs,.franja,.enlaces{{display:grid;grid-template-columns:118pt repeat(4,1fr);column-gap:16pt}}
    .mom{{display:flex;align-items:baseline;gap:8pt;padding:0 0 7pt;border-bottom:2.4pt solid {TINTA};margin-bottom:10pt}}
    .franja{{border-radius:16pt;padding:10pt 0 10pt 14pt;align-items:center}}
    .lab{{display:flex;flex-direction:column;align-items:flex-start;gap:4pt}}
    .celda{{padding-right:4pt}}
    .enl{{display:flex;align-items:center;gap:8pt;height:34pt;font-size:19.9pt;line-height:24pt;font-weight:600}}
    """
    return 'figura-v8-sistema', f'<div class="ficha">{g}</div>', css, DOBLE, ''


# =============================================================== Figura 30 · Qué se registró en cada relevo (ancho completo)
@figura('registro')
def registro():
    """Dos listas: lo que la aplicación registra sola, en el orden del ciclo, y lo que responde la persona, con sus
    opciones. Lo primero muestra qué hizo la persona; lo segundo, por qué."""
    tramos = [('editar', 'Lila', 'Preparar', 'Actividad, primer paso, lugar, apps y tiempo'),
              ('contando', 'Amarillo', 'Activar', 'Cuándo se activó y si fue a mano o solo'),
              ('suena', 'Durazno', 'Sonar', 'Dónde sonó y cómo se calló'),
              ('comentario', 'Cielo', 'Responder', 'Cada respuesta y cuánto tardó'),
              ('uso', 'Lima', 'Medir', 'El uso de las apps 10 minutos antes y después')]
    izq = ''.join(f'<div class="fl2">{cuadro(i, c, 44, 26)}<span class="sb">{t}</span><span>{d}</span></div>' for i, c, t, d in tramos)
    # Las preguntas y sus opciones, en el orden de la app durante la prueba (Anexo I, I.5).
    preguntas = [('¿Notaste el aviso apenas sonó?<br><span class="gris">Solo en la etapa con el teléfono</span>', ['Enseguida', 'Un rato después', 'No lo noté']),
                 ('¿Cómo te cayó el sonido?', ['Bien', 'Normal', 'Mal']),
                 ('Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla?', ['Sí', 'A medias', 'No']),
                 ('¿Recordaste cómo empezar?', ['Sí', 'No']),
                 ('<b class="sb">¿Qué decidiste?</b>', ['Comencé la actividad', 'La dejé para después', 'Cambié de idea'])]
    der = ''.join(f'<div class="fq"><span>{q}</span><span class="op">{"<i>·</i>".join(o)}</span></div>' for q, o in preguntas)
    css = f"""
    .dos{{display:grid;grid-template-columns:640pt 1fr;column-gap:56pt}}
    .h{{display:flex;align-items:center;gap:12pt;padding-bottom:8pt;border-bottom:2.4pt solid {TINTA};margin-bottom:4pt}}
    .h .gris{{margin-left:6pt}}
    .fl2{{display:grid;grid-template-columns:44pt 122pt 1fr;column-gap:16pt;align-items:center;min-height:64pt;border-bottom:1.4pt solid {LINEA}}}
    .fq{{display:flex;justify-content:space-between;align-items:center;gap:24pt;min-height:64pt;border-bottom:1.4pt solid {LINEA}}}
    .fq .gris{{font-size:19.9pt}}
    .fl2:last-child,.fq:last-child{{border-bottom:0}}
    .op{{color:{GRIS};text-align:right;white-space:nowrap}} .op i{{font-style:normal;padding:0 11pt;color:#B9B2AA}}
    """
    cuerpo = (f'<div class="ficha"><div class="dos">'
              f'<div><div class="h">{icono("telefono", 34)}<span class="sb">Lo que registra la aplicación</span></div>{izq}</div>'
              f'<div><div class="h">{icono("usuario", 34)}<span class="sb">Lo que responde la persona</span><span class="gris">Puede omitir cualquier pregunta</span></div>{der}</div>'
              '</div></div>')
    return 'figura-v8-registro', cuerpo, css, ANCHO, ''


# =============================================================== Figura 34 · Comparación propuesta (una columna)
@figura('comparacion')
def comparacion():
    """Seis personas, tres semanas y tres condiciones: cada persona pasa por A, B y C en un orden distinto. Abajo, qué
    es cada condición y dos reglas de la comparación."""
    cond = {'A': ('Lima', 'lugar', 'El objeto junto al primer paso'),
            'B': ('Cielo', 'tag', 'El mismo objeto en un lugar sin relación'),
            'C': ('Amarillo', 'telefono', 'Una notificación genérica en el teléfono')}
    ordenes = ['ABC', 'ACB', 'BAC', 'BCA', 'CAB', 'CBA']
    g = '<div></div>' + ''.join(f'<div class="sem">Semana {k}</div>' for k in (1, 2, 3))
    for p, o in enumerate(ordenes, 1):
        g += f'<div class="per">Persona {p}</div>' + ''.join(f'<div class="cd" style="background:{grad(cond[x][0])}">{x}</div>' for x in o)
    ley = ''.join(f'<div class="ly"><div class="cd chica" style="background:{grad(c)}">{k}</div>{icono(ic, 30, GRIS)}<div>{t}</div></div>' for k, (c, ic, t) in cond.items())
    notas = (f'<div class="nts"><div class="nt">{icono("suena", 30, GRIS)}<span>El mismo sonido y las mismas preguntas en las tres condiciones</span></div>'
             f'<div class="nt">{icono("tiempo", 30, GRIS)}<span>Algunos relevos se cumplen sin señal para medir cuánto ayuda solo prepararlo</span></div></div>')
    css = f"""
    .lead{{color:{GRIS};margin-bottom:16pt}}
    .g{{display:grid;grid-template-columns:112pt repeat(3,1fr);column-gap:8pt;row-gap:6pt}}
    .sem{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{TINTA};padding:0 0 6pt 2pt;border-bottom:2.4pt solid {TINTA};margin-bottom:5pt}}
    .per{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS};align-self:center}}
    .cd{{height:38pt;border-radius:11pt;display:flex;align-items:center;justify-content:center;font-weight:600}}
    .cd.chica{{width:42pt;height:42pt;flex:none}}
    .leyes{{display:grid;row-gap:10pt;margin-top:22pt}} .ly{{display:flex;gap:14pt;align-items:center}}
    .nts{{display:grid;gap:10pt;margin-top:18pt;padding-top:14pt;border-top:1.4pt solid {LINEA}}}
    .nt{{display:flex;gap:14pt;align-items:flex-start;color:{GRIS}}}
    """
    cuerpo = (f'<div class="ficha col"><div class="lead">Cada persona pasa por A, B y C en otro orden</div>'
              f'<div class="g">{g}</div><div class="leyes">{ley}</div>{notas}</div>')
    return 'figura-v8-comparacion', cuerpo, css, COL, ''


if __name__ == '__main__':
    pedidas = sys.argv[1:] or list(FIGURAS)
    for clave in pedidas:
        nombre, cuerpo, css, ancho, js = FIGURAS[clave]()
        generar(nombre, cuerpo, css, ancho, js)
