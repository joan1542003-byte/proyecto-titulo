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



# Los cuatro momentos del recorrido, con el color de la identidad que les corresponde (Figura 19 de la memoria):
# preparar (primer paso), seguir en el teléfono (tiempo), oír la señal (lugar) y decidir (decisión).
MOMENTOS = [('Preparar', 'Cielo'), ('Seguir en el teléfono', 'Amarillo'), ('Oír la señal', 'Lima'), ('Decidir', 'Rubor')]
CSS_MOMENTO = f"""
.mh{{display:flex;align-items:baseline;gap:10pt;padding-bottom:9pt;margin-bottom:16pt;position:relative}}
.mh .n{{color:{GRIS}}} .mh .sb{{white-space:nowrap}}
.mh::after{{content:'';position:absolute;left:0;right:0;bottom:0;height:6pt;border-radius:3pt;background:var(--barra)}}
"""


def cabeza_momento(k):
    nombre, color = MOMENTOS[k]
    return (f'<div class="mh" style="--barra:linear-gradient(90deg,{DEGRADE[color][0]},{INTENSO[color]})">'
            f'<span class="n">{k + 1}</span><span class="sb">{nombre}</span></div>')

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


# =============================================================== Figura 7 · Método Framework (dos columnas)
@figura('framework')
def framework():
    """Arriba, los cinco momentos del método. Al centro, la matriz con los códigos de cada entrevista (Anexo A, Tabla A4):
    una fila por persona y una columna por tema. El color marca los códigos que acercan un episodio a cada tipo ideal
    —rosado, el usuario principal; verde, el usuario límite—, así la lectura por tema muestra de dónde salen los dos
    tipos. Pedido del autor del 25 de noviembre de 2026: la matriz vacía no se entendía."""
    momentos = [('Familiarización', 'Leer las ocho transcripciones'),
                ('Marco analítico', 'Temas previos y temas nuevos'),
                ('Indexación', 'Asignar un tema a cada fragmento'),
                ('Matriz', 'Resumir cada caso por tema'),
                ('Interpretación', 'Leerla por persona y por tema')]
    temas = ['Uso del teléfono', 'Intención', 'Recuerdo', 'Cierre', 'Obligación pendiente', 'Otra actividad valorada']
    casos = [('Dirigido', 'Clara', 'Débil', 'Positivo', '—', 'Sí'),
             ('Continuidad', 'Desplazada', 'Claro', 'Ambivalente', 'Sí', 'Sí'),
             ('Continuidad', 'Desplazada', 'Débil', 'Ambivalente', 'Sí', 'Sí'),
             ('Dirigido y continuidad', 'Clara', 'Débil', 'Positivo', '—', '—'),
             ('Continuidad', '—', 'Débil', 'Ambivalente', '—', 'Sí'),
             ('Relacional y continuidad', 'Clara', 'Claro', 'Positivo', '—', 'Sí'),
             ('Dirigido', 'Clara', 'Claro', 'Positivo', 'No', '—'),
             ('Continuidad', '—', 'Débil', 'Positivo', 'No', 'Sí')]
    # Columna, valor → tipo al que acerca el código.
    tono = {(1, 'Desplazada'): 'Rubor', (3, 'Ambivalente'): 'Rubor', (4, 'Sí'): 'Rubor',
            (1, 'Clara'): 'Lima', (3, 'Positivo'): 'Lima', (4, 'No'): 'Lima'}
    pasos = ''.join(f'<div class="paso"><div class="pc"><span class="n">{k + 1}</span><span class="sb">{t}</span></div><div class="gris">{d}</div></div>'
                    + (f'<div class="sep">{flecha(24)}</div>' if k < 4 else '') for k, (t, d) in enumerate(momentos))
    g = '<div></div>' + ''.join(f'<div class="th">{t}</div>' for t in temas)
    for p, fila in enumerate(casos, 1):
        g += f'<div class="pr">Persona {p}</div>'
        for k, v in enumerate(fila):
            if v == '—':
                g += '<div class="c"><span class="nada">—</span></div>'
                continue
            color = tono.get((k, v))
            fondo = f'linear-gradient(100deg,{DEGRADE[color][0]},{DEGRADE[color][1]})' if color else PAPEL
            g += f'<div class="c"><span class="cod" style="background:{fondo}">{v}</span></div>'
    tipos = ('<div class="tipos">'
             f'<div class="tipo">{punto("Rubor", 26)}<div><div class="sb">Usuario principal</div><div class="gris">La sesión sigue sin una nueva decisión y otra actividad deja de estar presente</div></div></div>'
             f'<div class="tipo">{punto("Lima", 26)}<div><div class="sb">Usuario límite</div><div class="gris">El ocio digital conserva sentido o no hay otra intención: no corresponde intervenir</div></div></div>'
             '</div>')
    css = f"""
    .pasos{{display:flex;align-items:flex-start;margin-bottom:28pt}}
    .paso{{flex:1;display:flex;flex-direction:column;gap:3pt}} .pc{{display:flex;gap:8pt;align-items:baseline;white-space:nowrap}} .pc .n{{color:{GRIS}}}
    .sep{{padding:0 8pt;margin-top:3pt}}
    .mz{{display:grid;grid-template-columns:118pt 1.75fr repeat(5,1fr);column-gap:8pt;row-gap:7pt;align-items:center}}
    .th{{font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS};padding-bottom:8pt;align-self:end}}
    .pr{{font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS}}}
    .c{{display:flex}}
    .cod{{display:inline-block;font-size:19.9pt;line-height:24pt;padding:6pt 12pt;border-radius:9pt;white-space:nowrap}}
    .nada{{font-size:19.9pt;line-height:36pt;color:#B9B2AA;padding-left:12pt}}
    .baja{{display:flex;align-items:center;gap:12pt;margin:26pt 0 14pt;padding-top:20pt;border-top:1.4pt solid {LINEA}}} .baja .gris{{margin-left:4pt}}
    .tipos{{display:grid;grid-template-columns:1fr 1fr;column-gap:36pt}}
    .tipo{{display:flex;gap:14pt;align-items:flex-start}} .tipo .pto{{margin-top:1pt}}
    """
    resultado = f'<div class="baja"><span class="sb">Dos tipos ideales</span><span class="gris">Situaciones que reúnen casos parecidos</span></div>{tipos}'
    cuerpo = f'<div class="ficha"><div class="pasos">{pasos}</div><div class="mz">{g}</div>{resultado}</div>'
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
        ('Durazno', 'Prueba', 'Tres personas durante cinco semanas. Tras cada señal: ¿supo qué quería hacer antes de mirar la pantalla? ¿Recordó cómo empezar? ¿Qué decidió?'),
        ('Rubor', 'Conclusiones', 'El ciclo funciona con tres personas. Aún no se puede afirmar que el objeto supere a la notificación ni que el lugar sea lo que ayuda.'),
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
              ('Cielo', 'Prueba', 'Tres personas, cinco semanas'),
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


# =============================================================== Figura 20 · Estados de un relevo (dos columnas)
@figura('estados')
def estados():
    """Los seis estados de un relevo (Anexo G), bajo los cuatro momentos del recorrido. En cada momento, sus estados uno
    bajo otro, con lo que pasa en cada uno; los momentos se leen de 1 a 4. Abajo, en palabras, los tres caminos que se
    salen de ese orden. Pedido del autor del 25 de noviembre de 2026: la versión con arcos y rótulos sueltos era confusa
    y «borrador» no era la palabra; ahora es «En preparación». Va en dos columnas, junto al texto que la nombra."""
    estados = [(0, 'editar', 'En preparación', 'Responde las preguntas'),
               (0, 'listo', 'Listo', 'Falta activarlo'),
               (1, 'esperando', 'En espera', 'Cuenta el tiempo de uso'),
               (2, 'suena', 'Sonando', 'Suena unos 30 segundos'),
               (2, 'silenciar', 'Silenciado', 'Se apagó el sonido'),
               (3, 'decidir', 'Cerrado', 'Respondió qué decidió')]
    cols = ''
    for k in range(4):
        dentro = [e for e in estados if e[0] == k]
        celdas = ''
        for j, (_, ic, nombre, texto) in enumerate(dentro):
            celdas += (f'<div class="st"><div class="cab2">{cuadro(ic, MOMENTOS[k][1], 44, 26)}<span class="sb nom">{nombre}</span></div>'
                       f'<div class="gris">{texto}</div></div>')
            if j < len(dentro) - 1:
                celdas += f'<div class="baja">{flecha(22, vertical=True)}</div>'
        cols += f'<div class="g">{cabeza_momento(k)}{celdas}</div>'
    otros = [('En espera', 'En preparación', 'Si la persona lo edita; conserva el tiempo contado si las apps son las mismas'),
             ('Sonando', 'Cerrado', 'Si la persona responde antes de silenciarlo'),
             ('En espera', 'Cerrado', 'Si la persona lo desactiva o lo elimina')]
    abajo = ''.join(f'<span class="sb">{a}</span>{flecha(30)}<span class="sb">{b}</span><span class="gris">{t}</span>' for a, b, t in otros)
    css = CSS_MOMENTO + f"""
    .gs{{display:grid;grid-template-columns:repeat(4,1fr);column-gap:26pt}}
    .g{{display:flex;flex-direction:column}}
    .st{{display:flex;flex-direction:column;gap:5pt}}
    .cab2{{display:flex;align-items:center;gap:10pt}}
    .nom{{font-size:21.5pt;line-height:26pt;white-space:nowrap}}
    .baja{{padding:2pt 0 2pt 11pt}} .baja .fl{{height:22pt}}
    .otros{{margin-top:14pt;padding-top:10pt;border-top:1.4pt solid {LINEA}}}
    .otros .cab{{margin-bottom:2pt}}
    .ls{{display:grid;grid-template-columns:max-content 30pt max-content 1fr;column-gap:12pt;row-gap:4pt;align-items:center}} .ls .gris{{margin-left:10pt}}
    """
    cuerpo = (f'<div class="ficha"><div class="gs">{cols}</div>'
              f'<div class="otros"><div class="cab">Otros caminos</div><div class="ls">{abajo}</div></div></div>')
    return 'figura-v8-estados', cuerpo, css, DOBLE, ''

# =============================================================== Figura 28 · Cómo funciona Relevo (dos columnas)
@figura('sistema')
def sistema():
    """Ocho pasos numerados, en los cuatro momentos del recorrido. Cada paso dice quién actúa —la persona, la aplicación
    o el Tag—, con su ícono, y qué hace. Se lee de 1 a 8. Pedido del autor del 25 de noviembre de 2026: la versión en
    carriles, con órdenes entre ellos, era difícil de entender. Los pasos de cada fila empiezan a la misma altura."""
    actor = {'persona': ('usuario', 'La persona'), 'app': ('telefono', 'La aplicación'), 'tag': ('tag', 'El Tag')}
    pasos = [(0, 'persona', 'Prepara el relevo: la actividad, su primer paso, el lugar y cuándo suena'),
             (0, 'tag', 'Queda junto al primer paso y suena una vez, de prueba'),
             (1, 'persona', 'Usa el teléfono como siempre'),
             (1, 'app', 'Suma el tiempo en las apps elegidas'),
             (2, 'app', 'Se cumple el tiempo: le ordena sonar al Tag'),
             (2, 'tag', 'Suena unos 30 segundos desde el lugar de la actividad. Si no responde, suena el teléfono'),
             (3, 'persona', 'Decide qué hacer y responde en la aplicación'),
             (3, 'app', 'Guarda la respuesta en el teléfono')]
    cols = ''
    n = 0
    for k in range(4):
        items = ''
        for _, quien, texto in [p for p in pasos if p[0] == k]:
            n += 1
            ic, nombre = actor[quien]
            items += (f'<div class="ps"><div class="qn"><span class="num">{n}</span>{icono(ic, 30, GRIS)}<span class="gris sb2">{nombre}</span></div>'
                      f'<div>{texto}</div></div>')
        cols += f'{cabeza_momento(k)}{items}'
    css = CSS_MOMENTO + f"""
    .cols{{display:grid;grid-template-columns:repeat(4,1fr);grid-template-rows:repeat(3,auto);grid-auto-flow:column;column-gap:28pt}}
    .ps{{display:flex;flex-direction:column;gap:6pt}} .ps+.ps{{margin-top:22pt;padding-top:18pt;border-top:1.4pt solid {LINEA}}}
    .qn{{display:flex;align-items:center;gap:10pt}}
    .num{{font-weight:600;font-size:23pt;min-width:18pt}} .sb2{{font-weight:600;font-size:19.9pt}}
    """
    return 'figura-v8-sistema', f'<div class="ficha"><div class="cols">{cols}</div></div>', css, DOBLE, ''

# =============================================================== Figura 32 · Qué se registró en cada relevo (dos columnas, a página completa)
@figura('registro')
def registro():
    """Dos listas, una sobre otra: lo que la aplicación registra sola, en el orden del ciclo, y lo que responde la
    persona, con sus opciones. Lo primero muestra qué hizo la persona; lo segundo, por qué. Desde el 25 de noviembre de
    2026 va en dos columnas, a página completa, con el rótulo y la nota en la primera."""
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
    .dos{{display:grid;grid-template-columns:1fr;row-gap:34pt}}
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
    return 'figura-v8-registro', cuerpo, css, DOBLE, ''


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
