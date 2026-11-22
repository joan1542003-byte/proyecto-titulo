"""Figuras nuevas del borrador v8 de la memoria de Relevo (segunda versión, 21 de noviembre de 2026).

Cada figura se diseña a su tamaño real en la memoria de 1920 × 1080 pt: una columna (551 pt), dos columnas
(1146 pt) o el ancho del texto (1742 pt). Así se colocan al 100 %, sin escalar, y su letra es la de las demás
figuras de la memoria, medida en el PDF del Pase: 20,6 pt en el texto de las figuras y 19,9 pt en los rótulos,
nunca menos. Los íconos son los de la app 4.7.2 (marca-e-iconos.json), de 30 a 40 pt; los números van sueltos,
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
    """Los cinco momentos en una línea; la matriz de personas (filas) y temas (columnas), como en el Anexo A; y los dos tipos ideales."""
    momentos = [('Familiarización', 'Leer las ocho transcripciones'),
                ('Marco analítico', 'Temas previos y códigos que surgen al leer'),
                ('Indexación', 'Marcar cada fragmento con su tema'),
                ('Matriz', 'Personas en filas, temas en columnas'),
                ('Interpretación', 'Patrones en cada caso y entre casos')]
    temas = ['Decidida o automática', 'Percepción del tiempo', 'Recuerdo', 'Alternativa valorada', 'Conflicto posterior',
             'Contexto', 'Estrategias previas', 'Intervención física', 'Autonomía']
    pasos = ''.join(f'<div class="paso"><div class="pc"><span class="n">{k + 1}</span><span class="sb">{t}</span></div><div class="gris">{d}</div></div>'
                    + (f'<div class="sep">{flecha(26)}</div>' if k < 4 else '') for k, (t, d) in enumerate(momentos))
    caso, tema = 3, 2   # la fila y la columna que se destacan: dentro de un caso y entre casos
    g = '<div></div>' + ''.join(f'<div class="th{" k" if j == tema else ""}">{t}</div>' for j, t in enumerate(temas))
    for p in range(1, 9):
        g += f'<div class="pr{" r" if p == caso else ""}">P{p}</div>' + ''.join(
            f'<div class="c{" r" if p == caso else ""}{" k" if j == tema else ""}" style="grid-row:{p + 1};grid-column:{j + 2}"></div>' for j in range(len(temas)))
    # Las franjas van debajo de las celdas: la fila de un caso y la columna de un tema se leen de corrido.
    g += (f'<div class="fr fr-f" style="grid-row:{caso + 1};grid-column:2 / span {len(temas)}"></div>'
          f'<div class="fr fr-c" style="grid-row:2 / span 8;grid-column:{tema + 2}"></div>')
    ley = ('<div class="ley"><span><i class="lr"></i><em><b>Dentro de cada caso:</b> una persona, todos sus temas</em></span>'
           '<span><i class="lk"></i><em><b>Entre casos:</b> un tema, todas las personas</em></span></div>')
    tipos = (f'<div class="tipos"><div class="tipo">{punto("Rubor", 28)}<div><div class="sb">Usuario principal</div>'
             '<div class="gris">La sesión sigue sin una nueva decisión, y otra actividad deja de estar presente</div></div></div>'
             f'<div class="tipo">{punto("Lima", 28)}<div><div class="sb">Usuario límite</div>'
             '<div class="gris">El ocio digital conserva sentido o no hay otra intención: no corresponde intervenir</div></div></div></div>')
    baja = f'<div class="baja">{flecha(34, vertical=True)}<span class="sb">Dos tipos ideales: situaciones, no personas</span></div>'
    css = f"""
    .pasos{{display:flex;align-items:flex-start;margin-bottom:28pt}}
    .paso{{flex:1;display:flex;flex-direction:column;gap:4pt}} .pc{{display:flex;gap:9pt;align-items:baseline}} .pc .n{{color:{GRIS}}}
    .sep{{padding:0 10pt;margin-top:3pt}}
    .mz{{display:grid;grid-template-columns:48pt repeat({len(temas)},1fr);column-gap:6pt;row-gap:5pt;align-items:end}}
    .th{{font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS};padding:0 0 7pt}} .th.k{{color:{TINTA}}}
    .pr{{font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS};align-self:center}} .pr.r{{color:{TINTA}}}
    .c{{height:25pt;border-radius:7pt;background:{PAPEL}}}
    .c{{position:relative;z-index:1}} .c.r,.c.k{{background:transparent}} .c.r.k{{background:linear-gradient(135deg,{DEGRADE['Cielo'][1]},{DEGRADE['Amarillo'][1]})}}
    .fr{{border-radius:8pt;align-self:stretch;z-index:0}} .fr-f{{background:{grad('Cielo', 90)}}} .fr-c{{background:{grad('Amarillo', 180)}}}
    .ley{{display:flex;gap:34pt;margin-top:16pt}} .ley span{{display:flex;align-items:center;gap:10pt}} .ley em{{font-style:normal}} .ley b{{font-weight:600}}
    .ley i{{width:22pt;height:22pt;border-radius:6pt;flex:none}} .lr{{background:{grad('Cielo')}}} .lk{{background:{grad('Amarillo')}}}
    .baja{{display:flex;align-items:center;gap:14pt;margin:16pt 0 14pt}}
    .tipos{{display:grid;grid-template-columns:1fr 1fr;gap:34pt;padding-left:4pt}}
    .tipo{{display:flex;gap:14pt;align-items:flex-start}} .tipo .pto{{margin-top:1pt}}
    """
    cuerpo = f'<div class="ficha"><div class="pasos">{pasos}</div><div class="mz">{g}</div>{ley}{baja}{tipos}</div>'
    return 'figura-v8-framework', cuerpo, css, DOBLE, ''


# =============================================================== Figura 13 · Cadena de la formulación (dos columnas)
@figura('formulacion')
def formulacion():
    """Una línea con seis puntos: se lee hacia abajo, del problema a las conclusiones; dos arcos a la derecha la leen al revés."""
    filas = [
        ('Lila', 'Problema', 'Que una intención propia vuelva a tiempo, con el teléfono libre y la decisión en manos de la persona.'),
        ('Cielo', 'Pregunta', '¿Cuál es el efecto de un sistema <i>phygital</i> que vincula una actividad pendiente con su lugar de inicio sobre el recuerdo oportuno de esa actividad durante el ocio digital?'),
        ('Amarillo', 'Hipótesis', 'Si el sistema vincula la actividad con el lugar donde comienza, la persona la recordará a tiempo. Tres supuestos: asociación, decisión y soporte.'),
        ('Lima', 'Objetivos', 'Entender el problema, diseñar el sistema, compararlo con una notificación y medir en hogares el recuerdo oportuno.'),
        ('Durazno', 'Prueba', 'Tres hogares, cinco semanas. Tras cada señal: ¿supo qué quería hacer antes de mirar la pantalla?, ¿recordó cómo empezar?, ¿qué decidió?'),
        ('Rubor', 'Conclusiones', 'El ciclo funciona en tres hogares. Aún no se puede afirmar que el objeto supere a la notificación ni que el lugar sea lo que ayuda.'),
    ]
    g = ''
    for k, (color, nombre, texto) in enumerate(filas):
        g += (f'<div class="et"><span id="p{k}">{punto(color, 30)}</span><span class="tit">{nombre}</span></div>'
              f'<div class="tx" id="t{k}">{texto}</div><div></div>')
    rotulos = ('<div class="rot" id="r1">La prueba mide la variable de la hipótesis</div>'
               '<div class="rot" id="r2">Las conclusiones responden la pregunta</div>')
    css = f"""
    .esc{{display:grid;grid-template-columns:236pt 1fr 270pt;row-gap:26pt;align-items:center}}
    .et{{display:flex;align-items:center;gap:18pt;position:relative;z-index:1}} .tx{{padding:0 22pt 0 0}}
    .rot{{position:absolute;font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS};width:190pt}}
    """
    # Una línea fina une los puntos (se lee hacia abajo); a la derecha, los arcos de la lectura al revés.
    js = """
    const s=capa();let h='';
    const a=r('p0'),z=r('p5');h+=`<path d="M${a.cx} ${a.cy}V${z.cy}" stroke="#E4DED6" stroke-width="3"/>`;
    for(let k=0;k<5;k++){const p=r('p'+k),q=r('p'+(k+1));const m=(p.b+q.y)/2;h+=punta(p.cx,m+6,'b',2.2);}
    const borde=Math.max(...[0,1,2,3,4,5].map(k=>r('t'+k).d))-14;
    const arco=(de,a,x)=>{const y1=r('t'+de).cy,y2=r('t'+a).cy,x0=borde+12;
      return trazo(`M${x0} ${y1}H${x-14}Q${x} ${y1} ${x} ${y1-14}V${y2+14}Q${x} ${y2} ${x-14} ${y2}H${x0+4}`,2.2)+punta(x0+2,y2,'i',2.2);};
    const x1=borde+44,x2=borde+250;
    h+=arco(4,2,x1)+arco(5,1,x2);s.innerHTML=h;s.style.zIndex=0;
    const r1=document.getElementById('r1'),r2=document.getElementById('r2');
    r1.style.left=(x1+14)+'pt';r1.style.top=(r('t3').cy-r1.getBoundingClientRect().height*PX/2)+'pt';
    r2.style.left=(x2-14-190)+'pt';r2.style.textAlign='right';r2.style.top=((r('t1').cy+r('t2').cy)/2-r2.getBoundingClientRect().height*PX/2)+'pt';
    """
    cuerpo = f'<div class="ficha"><div class="esc">{g}</div>{rotulos}</div>'
    return 'figura-v8-formulacion', cuerpo, css, DOBLE, js


# =============================================================== Figura 14 · Método del proyecto (una columna)
@figura('metodo')
def metodo():
    """Cuatro fuentes que llevan a una línea de cinco etapas; un bucle a la derecha vuelve de los cambios al diseño."""
    fuentes = [('leer', 'Revisión bibliográfica'), ('entrevistas', 'Ocho entrevistas'),
               ('datos', 'Encuesta de 53 respuestas'), ('buscar', 'Estado del arte')]
    etapas = [('Rubor', 'Criterios', 'Ocho criterios de diseño'),
              ('Durazno', 'Diseño', 'La aplicación y el objeto'),
              ('Cielo', 'Prueba', 'Tres hogares, cinco semanas, con el Tag y con el teléfono'),
              ('Amarillo', 'Hallazgos', 'Lo que hicieron las personas, no solo lo que dijeron'),
              ('Lima', 'Cambios', 'Nueve cambios en la aplicación')]
    fu = ''.join(f'<div class="fu">{icono(i, 32, GRIS)}<span>{t}</span></div>' for i, t in fuentes)
    et = ''.join(f'<div class="et" id="e{k}"><span id="p{k}">{punto(c, 30)}</span><div><div class="sb">{t}</div><div class="gris">{d}</div></div></div>'
                 for k, (c, t, d) in enumerate(etapas))
    css = f"""
    .fus{{display:grid;row-gap:8pt;padding-bottom:14pt;border-bottom:2.4pt solid {TINTA}}}
    .fu{{display:flex;align-items:center;gap:12pt;line-height:25pt}}
    .ets{{display:grid;row-gap:26pt;padding:26pt 62pt 0 0;position:relative}}
    .et{{display:flex;gap:18pt;align-items:flex-start;position:relative;z-index:1}} .et .pto{{margin-top:0}}
    .iterar{{position:absolute;font-size:19.9pt;line-height:24pt;font-weight:600;color:{GRIS};transform:rotate(-90deg);white-space:nowrap}}
    """
    js = """
    const s=capa();let h='';
    const a=r('p0'),z=r('p4');h+=`<path d="M${a.cx} ${a.cy}V${z.cy}" stroke="#E4DED6" stroke-width="3"/>`;
    for(let k=0;k<4;k++){const p=r('p'+k),q=r('p'+(k+1));h+=punta(p.cx,(p.b+q.y)/2+6,'b',2.2);}
    // De las fuentes (la raya de abajo) baja una flecha al primer punto.
    const raya=document.querySelector('.fus').getBoundingClientRect(),fi=document.querySelector('.ficha').getBoundingClientRect();
    const yr=(raya.bottom-fi.top)*PX;h+=trazo(`M${a.cx} ${yr+2}V${a.y-6}`,2.2)+punta(a.cx,a.y-6,'b',2.2);
    // Bucle: de «Cambios» vuelve a «Diseño», por la derecha.
    const W=fi.width*PX,xb=W-22.3-20;const y1=r('p1').cy,y4=r('p4').cy;
    h+=trazo(`M${r('e4').d+12} ${y4}H${xb-14}Q${xb} ${y4} ${xb} ${y4-14}V${y1+14}Q${xb} ${y1} ${xb-14} ${y1}H${r('e1').d+14}`,2.2)+punta(r('e1').d+12,y1,'i',2.2);
    s.innerHTML=h;
    const it=document.getElementById('iterar');const ib=it.getBoundingClientRect();
    it.style.left=(xb+16-ib.width*PX/2)+'pt';it.style.top=((y1+y4)/2-ib.height*PX/2)+'pt';
    """
    cuerpo = (f'<div class="ficha col"><div class="fus">{fu}</div><div class="ets">{et}</div>'
              '<div class="iterar" id="iterar">Iterar</div></div>')
    return 'figura-v8-metodo', cuerpo, css, COL, js


# =============================================================== Figura 18 · Estados de un relevo (una columna)
@figura('estados')
def estados():
    """El ciclo de un relevo de arriba abajo, en seis estados. A la derecha, desde «Esperando», editar vuelve a
    «Borrador» y desactivar lleva a «Cerrado»; a la izquierda, responder lleva de «Sonando» a «Cerrado» sin pasar por el
    silencio. Lienzo fijo, con coordenadas; cada rótulo cabe en el ancho de la columna."""
    W, H = round(COL - 2 * 22.3, 1), 662
    x0, w, h = 128, 180, 56
    orden = [('borrador', 'Borrador', 'Lila', 'editar'), ('listo', 'Listo', 'Cielo', 'listo'), ('esperando', 'Esperando', 'Amarillo', 'contando'),
             ('sonando', 'Sonando', 'Durazno', 'suena'), ('silenciado', 'Silenciado', 'Neutro', 'silenciar'), ('cerrado', 'Cerrado', 'Rubor', 'decidir')]
    ys = {k: 84 + 98 * i for i, (k, *_) in enumerate(orden)}
    nodos = ''.join(f'<div class="st" style="left:{x0-w/2}pt;top:{ys[k]-h/2}pt;width:{w}pt;height:{h}pt;background:{grad(c, 100)}">{icono(ic, 28)}<span class="tit">{t}</span></div>'
                    for k, t, c, ic in orden)

    def punta(x, y, d):
        k = 8
        return {'d': f'M{x-k} {y-k*.85}L{x} {y}L{x-k} {y+k*.85}', 'i': f'M{x+k} {y-k*.85}L{x} {y}L{x+k} {y+k*.85}',
                'b': f'M{x-k*.85} {y-k}L{x} {y}L{x+k*.85} {y-k}'}[d]
    c = []
    arriba = lambda k: ys[k] - h / 2
    abajo = lambda k: ys[k] + h / 2
    c += [f'M{x0} 16V{arriba("borrador")-6}', punta(x0, arriba('borrador') - 5, 'b')]
    claves = [k for k, *_ in orden]
    for a, b in zip(claves, claves[1:]):
        c += [f'M{x0} {abajo(a)+6}V{arriba(b)-6}', punta(x0, arriba(b) - 5, 'b')]
    c += [f'M{x0} {abajo("cerrado")+6}V{H-26}', punta(x0, H - 25, 'b')]
    der, izq = x0 + w / 2, x0 - w / 2
    xd = W - 14
    ye = ys['esperando']
    # Editar: de «Esperando» vuelve a «Borrador»; desactivar o eliminar: de «Esperando» a «Cerrado». Los dos, por la derecha.
    c += [f'M{der+6} {ye-10}H{xd-14}Q{xd} {ye-10} {xd} {ye-24}V{ys["borrador"]+14}Q{xd} {ys["borrador"]} {xd-14} {ys["borrador"]}H{der+7}', punta(der + 6, ys['borrador'], 'i')]
    c += [f'M{der+6} {ye+10}H{xd-14}Q{xd} {ye+10} {xd} {ye+24}V{ys["cerrado"]-14}Q{xd} {ys["cerrado"]} {xd-14} {ys["cerrado"]}H{der+7}', punta(der + 6, ys['cerrado'], 'i')]
    # Responder sin silenciar: de «Sonando» a «Cerrado», por la izquierda.
    xi = 10
    c += [f'M{izq-6} {ys["sonando"]}H{xi+14}Q{xi} {ys["sonando"]} {xi} {ys["sonando"]+14}V{ys["cerrado"]-14}Q{xi} {ys["cerrado"]} {xi+14} {ys["cerrado"]}H{izq-7}', punta(izq - 6, ys['cerrado'], 'd')]
    svg = (f'<svg width="{W}pt" height="{H}pt" viewBox="0 0 {W} {H}" style="position:absolute;left:0;top:0;overflow:visible">'
           + ''.join(f'<path d="{p}" fill="none" stroke="{TINTA}" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"/>' for p in c)
           + f'<circle cx="{x0}" cy="9" r="9" fill="{TINTA}"/><circle cx="{x0}" cy="{H-12}" r="11" fill="none" stroke="{TINTA}" stroke-width="2.2"/><circle cx="{x0}" cy="{H-12}" r="6" fill="{TINTA}"/></svg>')
    medio = lambda a, b: (abajo(a) + arriba(b)) / 2
    xr = der + 18
    rot = [
        (xr, 40, 'editar: el tiempo ya<br>contado sigue si las<br>apps son las mismas', 'l'),
        (xr, medio('borrador', 'listo'), 'con todo completo', 'l'),
        (xr, medio('listo', 'esperando'), 'Activar el relevo', 'l'),
        (xr, medio('esperando', 'sonando'), 'se cumple el tiempo', 'l'),
        (xr, medio('sonando', 'silenciado'), 'la silencia', 'l'),
        (xr, medio('silenciado', 'cerrado'), 'responde u omite', 'l'),
        (xr, ys['cerrado'] + 44, 'desactivar o eliminar', 'l'),
    ]
    rots = ''.join(f'<div class="rt {al}" style="left:{x}pt;top:{y}pt">{t}</div>' for x, y, t, al in rot)
    # «responde», sobre la línea de la izquierda, girado: a ese lado no cabe derecho.
    rots += f'<div class="rt v" style="left:{xi}pt;top:{(ys["silenciado"] + ys["cerrado"]) / 2 - 20}pt">responde</div>'
    css = f"""
    .lienzo{{position:relative;width:{W}pt;height:{H}pt}}
    .rt.v{{transform:translate(-50%,-50%) rotate(-90deg);background:#fff;padding:0 6pt}}
    .st{{position:absolute;display:flex;align-items:center;justify-content:center;gap:10pt;border-radius:999pt}}
    .st .tit{{font-size:21.5pt}}
    .rt{{position:absolute;color:{GRIS};white-space:nowrap;line-height:25pt}}
    .rt.r{{transform:translate(-100%,-50%);text-align:right}} .rt.l{{transform:translate(0,-50%);text-align:left}}
    """
    cuerpo = f'<div class="ficha col"><div class="lienzo">{svg}{nodos}{rots}</div></div>'
    return 'figura-v8-estados', cuerpo, css, COL, ''


# =============================================================== Figura 26 · Cómo funciona Relevo (ancho completo)
@figura('sistema')
def sistema():
    """Tres carriles —la persona, la aplicación y el Tag— en los cuatro momentos, con las órdenes que viajan entre ellos.
    Cada carril es una franja con el degradado de su color, que se desvanece hacia la derecha; el texto va sin cajas."""
    momentos = ['Preparar', 'Seguir en el teléfono', 'Oír la señal', 'Decidir']
    persona = ['Anota la actividad y deja el Tag junto al primer paso',
               'Usa el teléfono como siempre',
               'Oye la señal desde el lugar de la actividad y puede callarla',
               'Responde: «Comencé», «La dejé para después» o «Cambié de idea»']
    app = ['Guarda el relevo y hace una prueba de sonido',
           'Suma el tiempo de las aplicaciones elegidas',
           'Ordena sonar; si el Tag no responde, suena el teléfono',
           'Guarda la respuesta y, con consentimiento, la envía']
    tag = ['Queda junto al primer paso', 'Espera conectado por Bluetooth', 'Suena unos 30 segundos', '']

    def carril(ic, color, nombre, celdas):
        luz = DEGRADE[color]
        out = (f'<div class="franja" style="background:linear-gradient(90deg,{luz[1]},#FFFFFF)">'
               f'<div class="lab">{icono(ic, 34)}<span class="sb">{nombre}</span></div>')
        return out + ''.join(f'<div class="celda">{c}</div>' for c in celdas) + '</div>'

    def enlace(textos):
        out = '<div class="enlaces"><div></div>'
        for t in textos:
            if not t:
                out += '<div></div>'
            elif t == 'sonar·callar':
                out += (f'<div class="enl">{flecha(28, vertical=True)}<span>sonar</span><span class="gris">·</span>'
                        f'<span>callar</span><div style="transform:rotate(180deg)">{flecha(28, vertical=True)}</div></div>')
            else:
                out += f'<div class="enl">{flecha(28, vertical=True)}<span>{t}</span></div>'
        return out + '</div>'

    cab = '<div class="cabs"><div></div>' + ''.join(f'<div class="mom"><span class="n gris">{k + 1}</span><span class="sb">{t}</span></div>' for k, t in enumerate(momentos)) + '</div>'
    g = (cab + carril('usuario', 'Rubor', 'Persona', persona) + enlace(['prepara', '', '', 'responde'])
         + carril('telefono', 'Cielo', 'Aplicación', app) + enlace(['prueba de sonido', '', 'sonar·callar', ''])
         + carril('tag', 'Lima', 'Tag', tag))
    css = f"""
    .ficha{{padding:24pt 26.7pt}}
    .cabs,.franja,.enlaces{{display:grid;grid-template-columns:200pt repeat(4,1fr);column-gap:22pt}}
    .mom{{display:flex;align-items:baseline;gap:10pt;padding:0 0 7pt;border-bottom:2.4pt solid {TINTA};margin-bottom:12pt}}
    .franja{{border-radius:18pt;padding:12pt 0 12pt 18pt;align-items:center}}
    .lab{{display:flex;align-items:center;gap:13pt}}
    .celda{{padding-right:6pt}}
    .enl{{display:flex;align-items:center;justify-content:flex-start;gap:9pt;height:40pt;font-size:19.9pt;line-height:24pt;font-weight:600}}
    """
    return 'figura-v8-sistema', f'<div class="ficha">{g}</div>', css, ANCHO, ''


# =============================================================== Figura 30 · Qué se registró en cada relevo (ancho completo)
@figura('registro')
def registro():
    """Dos listas: lo que la aplicación registra en cada tramo del ciclo y las preguntas de un toque, con sus opciones."""
    tramos = [('editar', 'Lila', 'Activar', 'Cuándo se activó el relevo'),
              ('contando', 'Amarillo', 'Contar', 'El tiempo de las aplicaciones elegidas'),
              ('suena', 'Durazno', 'Sonar', 'Si sonó, dónde y cómo se calló'),
              ('comentario', 'Cielo', 'Preguntar', 'Cada respuesta y cuánto tardó'),
              ('decidir', 'Rubor', 'Decidir', 'Qué decidió la persona')]
    izq = ''.join(f'<div class="fl2">{cuadro(i, c, 44, 26)}<span class="sb">{t}</span><span>{d}</span></div>' for i, c, t, d in tramos)
    # Las cuatro preguntas de un toque, en el orden y con las opciones de la app durante la prueba (Anexo I, I.5).
    preguntas = [('¿Notaste el aviso apenas sonó? <span class="gris">(solo con el teléfono)</span>', ['Enseguida', 'Un rato después', 'No lo noté']),
                 ('¿Cómo te cayó el sonido?', ['Bien', 'Normal', 'Mal']),
                 ('Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla?', ['Sí', 'A medias', 'No']),
                 ('¿Recordaste cómo empezar?', ['Sí', 'No']),
                 ('<b class="sb">¿Qué decidiste?</b>', ['Comencé la actividad', 'La dejé para después', 'Cambié de idea'])]
    der = ''.join(f'<div class="fq"><span>{q}</span><span class="op">{"<i>·</i>".join(o)}</span></div>' for q, o in preguntas)
    css = f"""
    .dos{{display:grid;grid-template-columns:600pt 1fr;column-gap:56pt}}
    .h{{display:flex;align-items:center;gap:12pt;padding-bottom:8pt;border-bottom:2.4pt solid {TINTA};margin-bottom:4pt}}
    .fl2{{display:grid;grid-template-columns:44pt 120pt 1fr;column-gap:16pt;align-items:center;padding:9pt 0;border-bottom:1.4pt solid {LINEA}}}
    .fq{{display:flex;justify-content:space-between;align-items:baseline;gap:24pt;padding:17pt 0;border-bottom:1.4pt solid {LINEA}}}
    .fl2:last-child,.fq:last-child{{border-bottom:0}}
    .op{{color:{GRIS};text-align:right;white-space:nowrap}} .op i{{font-style:normal;padding:0 11pt;color:#B9B2AA}}
    """
    cuerpo = (f'<div class="ficha"><div class="dos">'
              f'<div><div class="h">{icono("telefono", 34)}<span class="sb">La aplicación registra, en cada tramo</span></div>{izq}</div>'
              f'<div><div class="h">{icono("usuario", 34)}<span class="sb">La persona responde con un toque, y puede saltar las preguntas</span></div>{der}</div>'
              '</div></div>')
    return 'figura-v8-registro', cuerpo, css, ANCHO, ''


# =============================================================== Figura 34 · Comparación propuesta (una columna)
@figura('comparacion')
def comparacion():
    """Seis personas, tres semanas y tres condiciones, cada persona en un orden distinto; abajo, qué es cada condición."""
    cond = {'A': ('Lima', 'lugar', 'El objeto junto al primer paso'),
            'B': ('Cielo', 'tag', 'El mismo objeto, en un lugar sin relación con la actividad'),
            'C': ('Amarillo', 'telefono', 'Una notificación genérica en el teléfono, sin la actividad escrita')}
    ordenes = ['ABC', 'ACB', 'BAC', 'BCA', 'CAB', 'CBA']
    g = '<div></div>' + ''.join(f'<div class="sem">Semana {k}</div>' for k in (1, 2, 3))
    for p, o in enumerate(ordenes, 1):
        g += f'<div class="per">Persona {p}</div>' + ''.join(f'<div class="cd" style="background:{grad(cond[x][0])}">{x}</div>' for x in o)
    ley = ''.join(f'<div class="ly"><div class="cd chica" style="background:{grad(c)}">{k}</div>{icono(ic, 30, GRIS)}<div>{t}</div></div>' for k, (c, ic, t) in cond.items())
    notas = (f'<div class="nts"><div class="nt">{icono("suena", 30, GRIS)}<span>El mismo sonido y las mismas preguntas en las tres condiciones</span></div>'
             f'<div class="nt">{icono("tiempo", 30, GRIS)}<span>Algunos relevos se cumplen sin señal, para ver cuánto se debe solo a haberlo preparado</span></div></div>')
    css = f"""
    .g{{display:grid;grid-template-columns:112pt repeat(3,1fr);column-gap:8pt;row-gap:6pt}}
    .sem{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS};padding:0 0 6pt 2pt;border-bottom:2.4pt solid {TINTA};margin-bottom:5pt}}
    .per{{font-size:19.9pt;line-height:25pt;font-weight:600;color:{GRIS};align-self:center}}
    .cd{{height:42pt;border-radius:12pt;display:flex;align-items:center;justify-content:center;font-weight:600}}
    .cd.chica{{width:44pt;height:44pt;flex:none}}
    .leyes{{display:grid;row-gap:12pt;margin-top:20pt}} .ly{{display:flex;gap:14pt;align-items:center}}
    .nts{{display:grid;gap:10pt;margin-top:16pt;padding-top:14pt;border-top:1.6pt solid {LINEA}}}
    .nt{{display:flex;gap:14pt;align-items:flex-start;color:{GRIS}}}
    """
    cuerpo = f'<div class="ficha col"><div class="g">{g}</div><div class="leyes">{ley}</div>{notas}</div>'
    return 'figura-v8-comparacion', cuerpo, css, COL, ''


if __name__ == '__main__':
    pedidas = sys.argv[1:] or list(FIGURAS)
    for clave in pedidas:
        nombre, cuerpo, css, ancho, js = FIGURAS[clave]()
        generar(nombre, cuerpo, css, ancho, js)
