"""Figuras nuevas del borrador v8 de la memoria de Relevo.

Cada figura se escribe en HTML con la tipografía y la paleta de Relevo, a la escala de la memoria en Affinity
(hojas de 1920 × 1080 pt; ancho de texto de 1742 pt). Chrome la convierte en un PDF vectorial, con el texto vivo,
para colocar en Affinity, y en un PNG para verla en el repositorio. Las figuras no llevan título ni nota: los pone
la memoria, en APA 7. Los íconos son los de la app 4.7.2 (marca-e-iconos.json).

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
ANCHO = 1742  # pt: el ancho del texto en la memoria


def icono(nombre, tam=26, color=TINTA, grosor=1.7):
    return (f'<svg class="ic" viewBox="0 0 24 24" width="{tam}" height="{tam}" style="color:{color}" fill="none" '
            f'stroke="currentColor" stroke-width="{grosor}" stroke-linecap="round" stroke-linejoin="round">{ICONOS[nombre]}</svg>')


def cuadro(nombre, color, tam=46, ic=26):
    return f'<div class="cuad" style="width:{tam}pt;height:{tam}pt;background:{LUZ[color]}">{icono(nombre, ic)}</div>'


def flecha(largo=46, vertical=False, color=TINTA):
    a = 22
    if vertical:
        return (f'<svg class="fl" width="{a}pt" height="{largo}pt" viewBox="0 0 {a} {largo}"><path d="M{a/2} 1.5V{largo-2.5}'
                f'M{a/2-6.5} {largo-10}L{a/2} {largo-2.5}L{a/2+6.5} {largo-10}" fill="none" stroke="{color}" stroke-width="2" '
                f'stroke-linecap="round" stroke-linejoin="round"/></svg>')
    return (f'<svg class="fl" width="{largo}pt" height="{a}pt" viewBox="0 0 {largo} {a}"><path d="M1.5 {a/2}H{largo-2.5}'
            f'M{largo-10} {a/2-6.5}L{largo-2.5} {a/2}L{largo-10} {a/2+6.5}" fill="none" stroke="{color}" stroke-width="2" '
            f'stroke-linecap="round" stroke-linejoin="round"/></svg>')


CSS = f"""
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Regular.ttf');font-weight:400}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Medium.ttf');font-weight:500}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-SemiBold.ttf');font-weight:600}}
@font-face{{font-family:'IS';src:url('{LETRA}/InstrumentSans-Italic.ttf');font-style:italic}}
*{{box-sizing:border-box;margin:0;padding:0}}
html,body{{background:transparent;-webkit-print-color-adjust:exact;print-color-adjust:exact}}
body{{font-family:'IS';color:{TINTA};font-size:19pt;line-height:25pt;font-feature-settings:'kern'}}
.ficha{{background:#fff;border-radius:27pt;padding:30pt 32pt;position:relative}}
.gris{{color:{GRIS}}} .sb{{font-weight:600}} .md{{font-weight:500}}
.chico{{font-size:16pt;line-height:21pt}}
.num{{display:inline-flex;align-items:center;justify-content:center;width:32pt;height:32pt;border-radius:50%;background:{TINTA};color:#fff;font-size:15pt;line-height:1;font-weight:600;flex:none}}
.ic{{display:block;flex:none}} .fl{{display:block;flex:none;overflow:visible}}
.cuad{{border-radius:14pt;display:flex;align-items:center;justify-content:center;flex:none}}
.caja{{background:{PAPEL};border-radius:16pt;padding:16pt 18pt}}
.rotulo{{font-size:15pt;line-height:19pt;color:{GRIS};font-weight:500}}
.pas{{display:inline-flex;align-items:center;padding:5pt 13pt;border-radius:999pt;font-size:16pt;line-height:20pt;font-weight:500;background:{PAPEL}}}
"""

MEDIR = """<script>document.fonts.ready.then(()=>{const f=document.querySelector('.ficha');
document.documentElement.setAttribute('data-alto',Math.ceil(f.getBoundingClientRect().height*0.75)+1);});</script>"""


def pagina(cuerpo, ancho, alto, css_extra='', medir=False, titulo='Figura de Relevo'):
    tam = f'@page{{size:{ancho}pt {alto}pt;margin:0}} body{{width:{ancho}pt;height:{alto}pt}}' if alto else f'body{{width:{ancho}pt}}'
    return (f'<!doctype html><html lang="es"><head><meta charset="utf-8"><title>{titulo}</title><style>{CSS}{css_extra}{tam}</style></head>'
            f'<body>{cuerpo}{MEDIR if medir else ""}</body></html>')


BASE = [CHROME, '--headless=new', '--disable-gpu', '--hide-scrollbars', '--no-sandbox', '--allow-file-access-from-files']


def alto_de(cuerpo, ancho, css):
    """Primera pasada: mide el alto de la ficha con la tipografía cargada."""
    ruta = os.path.join(AQUI, '_medir.html')
    open(ruta, 'w', encoding='utf-8').write(pagina(cuerpo, ancho, None, css, medir=True))
    dom = subprocess.run(BASE + ['--virtual-time-budget=4000', f'--window-size={round(ancho*4/3)},3000', '--dump-dom', 'file://' + ruta],
                         capture_output=True, text=True).stdout
    os.remove(ruta)
    m = re.search(r'data-alto="(\d+)"', dom)
    if not m:
        raise SystemExit('no se pudo medir la figura')
    return int(m.group(1))


def generar(nombre, cuerpo, css, ancho=ANCHO, alto=None):
    if alto is None:
        alto = alto_de(cuerpo, ancho, css)
    ruta = os.path.join(AQUI, nombre + '.html')
    open(ruta, 'w', encoding='utf-8').write(pagina(cuerpo, ancho, alto, css, titulo=TITULOS.get(nombre, 'Figura de Relevo')))
    subprocess.run(BASE + ['--force-device-scale-factor=1.5', '--virtual-time-budget=4000', f'--window-size={round(ancho*4/3)},{round(alto*4/3)}',
                           f'--screenshot={os.path.join(AQUI, nombre + ".png")}', 'file://' + ruta],
                   check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    subprocess.run(BASE + ['--no-pdf-header-footer', '--virtual-time-budget=4000', f'--print-to-pdf={os.path.join(AQUI, nombre + ".pdf")}', 'file://' + ruta],
                   check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
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


# =============================================================== 1. Cadena de la formulación
@figura('formulacion')
def formulacion():
    pasos = [
        ('advertencia', 'Lila', 'Problema', 'Durante algunas sesiones de ocio digital, una actividad que la persona quería hacer vuelve cuando la ocasión ya pasó.'),
        ('ayuda', 'Cielo', 'Pregunta', '¿Cuál es el efecto de vincular la actividad con su lugar de inicio sobre el recuerdo oportuno?'),
        ('hipotesis', 'Amarillo', 'Hipótesis', 'Si la actividad se vincula con el lugar donde comienza, la persona la recordará a tiempo.'),
        ('ruta', 'Lima', 'Objetivos', None),
        ('datos', 'Durazno', 'Prueba', None),
        ('validacion', 'Rubor', 'Conclusiones', None),
    ]
    extra = {
        'Hipótesis': '<div class="chips"><span class="pas">Asociación</span><span class="pas">Decisión</span><span class="pas">Soporte</span></div>',
        'Objetivos': '<ol class="lista"><li><b>1</b>Entender el problema</li><li><b>2</b>Diseñar el sistema</li><li><b>3</b>Comparar con una notificación</li><li><b>4</b>Probar en hogares y medir el recuerdo oportuno</li></ol>',
        'Prueba': '<ul class="lista pun"><li>¿Supo qué quería hacer antes de mirar la pantalla?</li><li>¿Recordó cómo empezar?</li><li>¿Qué decidió?</li><li>¿Notó el aviso? (teléfono)</li></ul>',
        'Conclusiones': '<div class="concl"><div><span class="si">Se puede afirmar</span>El ciclo funciona en tres hogares.</div><div><span class="no">No se puede afirmar</span>Que el objeto supere a la notificación, ni que el lugar sea lo que ayuda.</div></div>',
    }
    cols = ''
    for k, (ic, color, titulo, texto) in enumerate(pasos):
        cuerpo = f'<p>{texto}</p>' if texto else ''
        cuerpo += extra.get(titulo, '')
        cols += (f'<div class="paso"><div class="cab">{cuadro(ic, color, 42, 24)}<span class="sb">{titulo}</span></div>{cuerpo}</div>')
        if k < len(pasos) - 1:
            cols += f'<div class="sep">{flecha(30)}</div>'
    vuelta = ('<div class="vuelta"><svg width="100%" height="44pt" viewBox="0 0 1000 44" preserveAspectRatio="none">'
              f'<path d="M985 2V30H15V8" fill="none" stroke="{TINTA}" stroke-width="2" vector-effect="non-scaling-stroke" stroke-linecap="round" stroke-linejoin="round"/>'
              '</svg><svg class="punta" width="16pt" height="12pt" viewBox="0 0 16 12"><path d="M1.5 10L8 2.5L14.5 10" fill="none" stroke="#141312" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/></svg>'
              '<span>Leída al revés, cada parte responde a la anterior: las conclusiones responden la pregunta, y la prueba mide la variable de la hipótesis.</span></div>')
    css = f"""
    .fila{{display:flex;align-items:stretch}}
    .paso{{flex:1;background:{PAPEL};border-radius:16pt;padding:18pt 16pt 20pt;display:flex;flex-direction:column;gap:12pt;font-size:16.5pt;line-height:22pt}}
    .cab{{display:flex;align-items:center;gap:11pt;font-size:19pt;line-height:23pt}}
    .sep{{display:flex;align-items:center;padding:0 5pt}}
    .chips{{display:flex;flex-wrap:wrap;gap:7pt}} .chips .pas{{background:#fff;font-size:15pt}}
    .lista{{list-style:none;display:grid;gap:7pt}} .lista li{{display:flex;gap:9pt}} .lista b{{font-weight:600;min-width:12pt}}
    .lista.pun li::before{{content:'';width:6pt;height:6pt;border-radius:50%;background:{TINTA};margin-top:8pt;flex:none}}
    .concl{{display:grid;gap:10pt}} .concl span{{display:block;font-weight:600;font-size:15pt;line-height:19pt;margin-bottom:2pt}}
    .si{{color:#3C7A1E}} .no{{color:#A0365F}}
    .vuelta{{position:relative;margin:4pt 7% 0 7%}} .vuelta .punta{{position:absolute;left:calc(1.5% - 8pt);top:0}}
    .vuelta span{{display:block;text-align:center;font-size:16pt;line-height:21pt;color:{GRIS};margin-top:6pt}}
    """
    return 'figura-v8-formulacion', f'<div class="ficha"><div class="fila">{cols}</div>{vuelta}</div>', css


# =============================================================== 2. Método del proyecto
@figura('metodo')
def metodo():
    fuentes = [('leer', 'Lila', 'Revisión bibliográfica', 'Memoria, atención y ocio digital'),
               ('entrevistas', 'Cielo', 'Entrevistas', '8 personas, analizadas con el método Framework'),
               ('datos', 'Amarillo', 'Encuesta', '53 respuestas'),
               ('buscar', 'Lima', 'Estado del arte', 'Productos, servicios y proyectos')]
    etapas = [('listo', 'Rubor', 'Criterios', '8 criterios de diseño'),
              ('objeto', 'Durazno', 'Diseño', 'Aplicación y objeto'),
              ('validacion', 'Cielo', 'Prueba', 'Tres hogares, cinco semanas: con el Tag y con el teléfono'),
              ('investigacion', 'Amarillo', 'Hallazgos', 'Lo que hicieron las personas, no solo lo que dijeron'),
              ('editar', 'Lima', 'Cambios', 'Nueve cambios en la aplicación después de la prueba')]
    izq = ''.join(f'<div class="fuente">{cuadro(i, c, 40, 22)}<div><div class="sb">{t}</div><div class="gris chico">{d}</div></div></div>' for i, c, t, d in fuentes)
    der = ''
    for k, (i, c, t, d) in enumerate(etapas):
        der += f'<div class="etapa" id="e{k}">{cuadro(i, c, 40, 22)}<div class="sb">{t}</div><div class="gris chico">{d}</div></div>'
        if k < len(etapas) - 1:
            der += f'<div class="sep">{flecha(30)}</div>'
    # La convergencia de las cuatro fuentes y la vuelta de los cambios al diseño se dibujan en un SVG del alto de la fila.
    css = f"""
    .fila{{display:grid;grid-template-columns:360pt 70pt 1fr;align-items:stretch}}
    .fuentes{{display:grid;gap:12pt}}
    .fuente{{display:flex;align-items:center;gap:14pt;background:{PAPEL};border-radius:16pt;padding:10pt 16pt;font-size:18pt;line-height:22pt;height:84pt}}
    .junta{{position:relative}}
    .cadena{{display:flex;align-items:center}}
    .etapa{{flex:1;align-self:stretch;background:{PAPEL};border-radius:16pt;padding:16pt 15pt;display:flex;flex-direction:column;gap:9pt;font-size:18pt;line-height:22pt;min-height:190pt}}
    .sep{{display:flex;align-items:center;padding:0 4pt}}
    .der{{display:flex;flex-direction:column;justify-content:center}}
    .bucle{{position:relative;height:70pt;margin-top:8pt}}
    .bucle span{{position:absolute;left:0;right:0;bottom:0;text-align:center;font-size:16pt;line-height:20pt;color:{GRIS}}}
    """
    junta = (f'<div class="junta"><svg width="70pt" height="100%" viewBox="0 0 70 100" preserveAspectRatio="none" style="position:absolute;inset:0">'
             + ''.join(f'<path d="M0 {y}C35 {y} 35 50 66 50" fill="none" stroke="{TINTA}" stroke-width="2" vector-effect="non-scaling-stroke"/>' for y in (12.5, 37.5, 62.5, 87.5))
             + '</svg><svg width="14pt" height="18pt" viewBox="0 0 14 18" style="position:absolute;right:-4pt;top:calc(50% - 9pt)"><path d="M3 2.5L11 9L3 15.5" fill="none" stroke="#141312" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/></svg></div>')
    # Bucle bajo la cadena: de «Cambios» (columna 5) a «Diseño» (columna 2).
    bucle = (f'<div class="bucle"><svg id="b" width="100%" height="44pt" style="position:absolute;top:0;left:0;overflow:visible"></svg><span>Iterar: cada cambio vuelve al diseño y a una nueva prueba</span></div>'
             """<script>document.fonts.ready.then(()=>{const b=document.getElementById('b'),r=b.getBoundingClientRect();
             const c=i=>{const e=document.getElementById('e'+i).getBoundingClientRect();return e.left+e.width/2-r.left};
             const x1=c(4),x2=c(1),y=30;b.innerHTML=`<path d="M${x1} 0V${y-12}Q${x1} ${y} ${x1-12} ${y}H${x2+12}Q${x2} ${y} ${x2} ${y-12}V6" fill="none" stroke="#141312" stroke-width="2.6" stroke-linecap="round"/><path d="M${x2-8.5} 14L${x2} 4L${x2+8.5} 14" fill="none" stroke="#141312" stroke-width="2.6" stroke-linecap="round" stroke-linejoin="round"/>`;});</script>""")
    cuerpo = f'<div class="ficha"><div class="fila"><div class="fuentes">{izq}</div>{junta}<div class="der"><div class="cadena">{der}</div>{bucle}</div></div></div>'
    return 'figura-v8-metodo', cuerpo, css


# =============================================================== 3. Método Framework
@figura('framework')
def framework():
    momentos = [('Familiarización', 'Leer las ocho transcripciones'),
                ('Marco analítico', 'Temas fijados de antemano y códigos que surgen al leer'),
                ('Indexación', 'Marcar cada fragmento con su tema'),
                ('Matriz', 'Una fila por persona y una columna por tema'),
                ('Interpretación', 'Patrones dentro de cada caso y entre casos')]
    temas = ['Decidida o automática', 'Percepción del tiempo', 'Recuerdo', 'Alternativa valorada', 'Conflicto posterior', 'Contexto', 'Estrategias previas', 'Intervención física', 'Autonomía']
    pasos = ''.join(f'<div class="mom"><span class="num">{k+1}</span><div><div class="sb">{t}</div><div class="gris chico">{d}</div></div></div>' for k, (t, d) in enumerate(momentos))
    cab = '<div></div>' + ''.join(f'<div class="tc">{t}</div>' for t in temas)
    filas = ''
    for p in range(1, 9):
        celdas = ''.join(f'<div class="c{" r" if p == 3 else ""}{" k" if j == 2 else ""}"></div>' for j in range(len(temas)))
        filas += f'<div class="pc{" r" if p == 3 else ""}">P{p}</div>{celdas}'
    matriz = (f'<div class="mz">{cab}{filas}</div>'
              '<div class="ley"><span><i class="lr"></i>Dentro de cada caso: una persona, todos sus temas</span>'
              '<span><i class="lk"></i>Entre casos: un tema, todas las personas</span></div>')
    salida = (f'<div class="sal"><div class="rotulo">Tipos ideales</div>'
              f'<div class="tipo">{cuadro("usuario", "Rubor", 40, 22)}<div><div class="sb">Usuario principal</div><div class="gris chico">El ocio digital sigue sin una nueva decisión y otra actividad deja de estar presente</div></div></div>'
              f'<div class="tipo">{cuadro("usuario", "Lima", 40, 22)}<div><div class="sb">Usuario límite</div><div class="gris chico">El ocio digital tiene sentido, y no corresponde intervenir</div></div></div>'
              '<div class="gris chico">Son situaciones, no personas: una misma persona puede estar en una u otra según el día.</div></div>')
    css = f"""
    .fila{{display:grid;grid-template-columns:330pt 1fr 44pt 320pt;gap:24pt;align-items:start}} .fl-f{{align-self:center}}
    .pasos{{display:grid;gap:15pt}} .mom{{display:flex;gap:13pt;align-items:flex-start;font-size:18pt;line-height:22pt}} .mom .num{{margin-top:-3pt}}
    .mz{{display:grid;grid-template-columns:52pt repeat({len(temas)},1fr);gap:5pt;align-items:end}}
    .tc{{font-size:13.5pt;line-height:16pt;color:{GRIS};font-weight:500;padding-bottom:6pt;hyphens:manual}}
    .pc{{font-size:15pt;font-weight:600;color:{GRIS};align-self:center}} .pc.r{{color:{TINTA}}}
    .c{{height:30pt;border-radius:7pt;background:{PAPEL}}}
    .c.r{{background:{LUZ['Cielo']}}} .c.k{{background:{LUZ['Amarillo']}}} .c.r.k{{background:linear-gradient(135deg,{LUZ['Cielo']} 50%,{LUZ['Amarillo']} 50%)}}
    .ley{{display:flex;gap:28pt;margin-top:16pt;font-size:15.5pt;line-height:20pt;color:{GRIS}}} .ley span{{display:flex;align-items:center;gap:9pt}}
    .ley i{{width:18pt;height:18pt;border-radius:5pt;flex:none}} .lr{{background:{LUZ['Cielo']}}} .lk{{background:{LUZ['Amarillo']}}}
    .sal{{display:grid;gap:14pt}} .tipo{{display:flex;gap:13pt;align-items:flex-start;background:{PAPEL};border-radius:16pt;padding:14pt 16pt;font-size:18pt;line-height:22pt}}
    """
    cuerpo = (f'<div class="ficha"><div class="fila"><div class="pasos">{pasos}</div><div>{matriz}</div><div class="fl-f">{flecha(40)}</div>{salida}</div></div>')
    return 'figura-v8-framework', cuerpo, css


# =============================================================== 4. La persona y el sistema
@figura('sistema')
def sistema():
    momentos = [('1', 'Preparar'), ('2', 'Seguir en el teléfono'), ('3', 'Oír la señal'), ('4', 'Decidir')]
    persona = ['Anota qué quiere hacer, cómo empieza, dónde y cuánto tiempo se da en ciertas aplicaciones. Deja el Tag junto al primer paso.',
               'Usa el teléfono como siempre.',
               'Oye la señal desde el lugar de la actividad, y puede callarla con el botón del Tag.',
               'Elige: «Comencé la actividad», «La dejé para después» o «Cambié de idea».']
    app = ['Guarda el relevo en el teléfono y hace una prueba de sonido.',
           'Cada segundo suma el tiempo de las aplicaciones elegidas, con el permiso de uso que la persona concede.',
           'Al cumplirse el tiempo, envía la orden de sonar. Si el Tag no responde, suena el teléfono.',
           'Guarda la respuesta. Con consentimiento, envía una copia con un código, no con el nombre.']
    tag = ['Queda junto al primer paso.', 'Espera conectado por Bluetooth.', 'Suena unos 30 segundos.', '']
    entre1 = ['prepara', '', '', 'responde']
    entre2 = ['prueba de sonido', '', 'sonar · callar', '']

    def carril(icono_c, color, nombre, celdas):
        h = f'<div class="lab">{cuadro(icono_c, color, 44, 24)}<span class="sb">{nombre}</span></div>'
        for c in celdas:
            h += f'<div class="celda{" vacia" if not c else ""}">{c}</div>'
        return h

    def enlace(textos, doble=None):
        h = '<div></div>'
        for k, t in enumerate(textos):
            if not t:
                h += '<div></div>'
                continue
            if '·' in t:
                h += f'<div class="enl">{flecha(30, vertical=True)}<span>sonar</span><span class="gris">·</span><span>callar</span><div style="transform:rotate(180deg)">{flecha(30, vertical=True)}</div></div>'
            else:
                h += f'<div class="enl">{flecha(30, vertical=True)}<span>{t}</span></div>'
        return h

    cab = '<div></div>' + ''.join(f'<div class="mom"><span class="num">{n}</span><span class="sb">{t}</span></div>' for n, t in momentos)
    grilla = (cab + carril('usuario', 'Rubor', 'Persona', persona) + enlace(entre1)
              + carril('telefono', 'Cielo', 'Aplicación, en el teléfono', app) + enlace(entre2)
              + carril('tag', 'Lima', 'Objeto: el Tag', tag))
    pie = (f'<div class="pie">{icono("privacidad", 24, GRIS)}<span>Entre el teléfono y el objeto solo viajan dos órdenes, sonar y callar: '
           'lo que la persona escribe se queda en el teléfono.</span></div>')
    css = f"""
    .g{{display:grid;grid-template-columns:236pt repeat(4,1fr);column-gap:14pt;row-gap:0}}
    .mom{{display:flex;align-items:center;gap:12pt;padding:0 2pt 12pt;border-bottom:2pt solid {TINTA};margin-bottom:16pt;font-size:20pt}}
    .lab{{display:flex;align-items:center;gap:13pt;font-size:19pt;line-height:23pt;padding-right:6pt}}
    .celda{{background:{PAPEL};border-radius:16pt;padding:14pt 17pt;font-size:17.5pt;line-height:23pt}}
    .celda.vacia{{background:transparent;border:1.5pt dashed {LINEA}}}
    .enl{{display:flex;align-items:center;justify-content:center;gap:8pt;height:52pt;font-size:15pt;line-height:18pt;font-weight:600}}
    .pie{{display:flex;align-items:center;gap:12pt;margin-top:22pt;color:{GRIS};font-size:16.5pt;line-height:21pt}}
    """
    return 'figura-v8-sistema', f'<div class="ficha"><div class="g">{grilla}</div>{pie}</div>', css


# =============================================================== 5. Estados de un relevo
@figura('estados')
def estados():
    # Lienzo fijo: los estados tienen lugar y tamaño conocidos, y las transiciones se dibujan con coordenadas.
    W, H = ANCHO - 64, 400
    s = {  # clave: (x centro, y centro, ancho, rótulo, color, ícono)
        'borrador': (120, 210, 196, 'Borrador', 'Lila', 'editar'),
        'listo': (420, 210, 170, 'Listo', 'Cielo', 'listo'),
        'espera': (760, 210, 210, 'En espera', 'Amarillo', 'contando'),
        'sonando': (1110, 210, 200, 'Sonando', 'Durazno', 'suena'),
        'silenciado': (1290, 345, 220, 'Silenciado', 'Neutro', 'silenciar'),
        'cerrado': (1530, 210, 196, 'Cerrado', 'Rubor', 'decidir'),
    }
    h = 64
    nodos = ''
    for k, (x, y, w, t, c, ic) in s.items():
        nodos += (f'<div class="st" style="left:{x-w/2}pt;top:{y-h/2}pt;width:{w}pt;height:{h}pt;background:{LUZ[c]}">'
                  f'{icono(ic, 24)}<span class="sb">{t}</span></div>')

    def bx(k, lado):
        x, y, w, *_ = s[k]
        return {'i': (x - w / 2, y), 'd': (x + w / 2, y), 'a': (x, y - h / 2), 'b': (x, y + h / 2)}[lado]

    caminos, rotulos = [], []

    def recta(a, b, texto, dx=0, dy=-16):
        (x1, y1), (x2, y2) = a, b
        caminos.append((f'M{x1+4} {y1}H{x2-6}', (x2, y2, 'd')))
        rotulos.append(((x1 + x2) / 2 + dx, y1 + dy, texto, 'c'))

    recta(bx('borrador', 'd'), bx('listo', 'i'), '')
    recta(bx('listo', 'd'), bx('espera', 'i'), '')
    recta(bx('espera', 'd'), bx('sonando', 'i'), '')
    recta(bx('sonando', 'd'), bx('cerrado', 'i'), '')
    # Rótulos sobre las rectas, en dos líneas cuando hace falta.
    rotulos.clear()
    rotulos += [(270, 150, 'actividad, primer paso,<br>apps y límite listos', 'c'),
                (590, 150, 'Activar el relevo', 'c'),
                (935, 150, 'se cumple<br>el tiempo', 'c'),
                (1320, 150, 'responde, haya<br>terminado o no<br>el sonido', 'c')]
    # Inicio
    caminos.append(('M-10 210H14', (22, 210, 'd')))
    # editar: de En espera a Borrador, por arriba
    x1, y1 = s['espera'][0] - 30, 210 - h / 2
    x2, y2 = s['borrador'][0], 210 - h / 2
    caminos.append((f'M{x1} {y1-4}V60Q{x1} 40 {x1-20} 40H{x2+20}Q{x2} 40 {x2} 60V{y2-8}', (x2, y2 - 2, 'b')))
    rotulos.append(((x1 + x2) / 2, 24, 'editar: el tiempo ya contado sigue si las apps son las mismas', 'c'))
    # desactivar o eliminar: de En espera a Cerrado, por arriba
    x1 = s['espera'][0] + 30
    x2 = s['cerrado'][0]
    ya = 210 - h / 2
    caminos.append((f'M{x1} {ya-4}V112Q{x1} 92 {x1+20} 92H{x2-20}Q{x2} 92 {x2} 112V{ya-8}', (x2, ya - 2, 'b')))
    rotulos.append(((x1 + x2) / 2, 76, 'desactivar o eliminar', 'c'))
    # Sonando → Silenciado → Cerrado
    xs, ys = s['sonando'][0], 210 + h / 2
    xl, yl = s['silenciado'][0] - s['silenciado'][2] / 2, 345
    caminos.append((f'M{xs} {ys+4}V{yl-16}Q{xs} {yl} {xs+16} {yl}H{xl-8}', (xl - 2, yl, 'd')))
    rotulos.append((xs - 18, 296, 'la persona<br>la silencia', 'r'))
    xr = s['silenciado'][0] + s['silenciado'][2] / 2
    xc = s['cerrado'][0]
    caminos.append((f'M{xr+4} {yl}H{xc-16}Q{xc} {yl} {xc} {yl-16}V{210+h/2+8}', (xc, 210 + h / 2 + 2, 'a')))
    rotulos.append((xc + 16, 296, 'responde<br>u omite', 'l'))
    # Fin
    caminos.append((f'M{s["cerrado"][0]+s["cerrado"][2]/2+4} 210H{W-24}', (W - 18, 210, 'd')))

    def punta(x, y, dir_):
        d = {'d': f'M{x-9} {y-7.5}L{x} {y}L{x-9} {y+7.5}', 'a': f'M{x-7.5} {y+9}L{x} {y}L{x+7.5} {y+9}', 'b': f'M{x-7.5} {y-9}L{x} {y}L{x+7.5} {y-9}'}[dir_]
        return f'<path d="{d}" fill="none" stroke="{TINTA}" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"/>'

    svg = (f'<svg width="{W}pt" height="{H}pt" viewBox="0 0 {W} {H}" style="position:absolute;left:0;top:0;overflow:visible">'
           + ''.join(f'<path d="{p}" fill="none" stroke="{TINTA}" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' + punta(*pt) for p, pt in caminos)
           + f'<circle cx="-16" cy="210" r="8" fill="{TINTA}"/><circle cx="{W-6}" cy="210" r="11" fill="none" stroke="{TINTA}" stroke-width="2"/><circle cx="{W-6}" cy="210" r="6" fill="{TINTA}"/>'
           + '</svg>')
    rot = ''.join(f'<div class="rt {al}" style="left:{x}pt;top:{y}pt">{t}</div>' for x, y, t, al in rotulos)
    css = f"""
    .lienzo{{position:relative;width:{W}pt;height:{H}pt;margin-left:20pt}}
    .st{{position:absolute;display:flex;align-items:center;justify-content:center;gap:10pt;border-radius:999pt;font-size:19pt;line-height:22pt}}
    .rt{{position:absolute;font-size:15pt;line-height:18.5pt;color:{GRIS};white-space:nowrap;transform:translate(-50%,-50%);text-align:center;background:#fff;padding:1pt 6pt}}
    .rt.r{{transform:translate(-100%,-50%);text-align:right}} .rt.l{{transform:translate(0,-50%);text-align:left}}
    """
    cuerpo = f'<div class="ficha"><div class="lienzo">{svg}{nodos}{rot}</div></div>'
    return 'figura-v8-estados', cuerpo, css


# =============================================================== 6. Qué se registró en cada relevo
@figura('registro')
def registro():
    tramos = [('editar', 'Lila', 'Activar'), ('contando', 'Amarillo', 'Contar'), ('suena', 'Durazno', 'Sonar'),
              ('comentario', 'Cielo', 'Preguntar'), ('decidir', 'Rubor', 'Decidir')]
    linea = ''.join(f'<div class="tr">{cuadro(i, c, 40, 22)}<span class="sb">{t_}</span></div>' + (f'<div class="sep">{flecha(28)}</div>' if k < len(tramos) - 1 else '')
                    for k, (i, c, t_) in enumerate(tramos))
    app = ['Cuándo se activó el relevo', 'El tiempo de las aplicaciones elegidas', 'Si sonó, dónde y cómo se calló',
           'Cada respuesta y cuánto tardó en responder', 'Qué decidió']
    preguntas = ['Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? <span class="op">Sí · A medias · No</span>',
                 '¿Recordaste cómo empezar? <span class="op">Sí · No</span>',
                 '¿Cómo te cayó el sonido? <span class="op">Bien · Normal · Mal</span>',
                 '¿Notaste el aviso apenas sonó? <span class="op">Solo con el teléfono</span>']
    caja_app = (f'<div class="caja2"><div class="t2">{icono("telefono", 24)}<span class="sb">La aplicación registra</span></div>'
                f'<ol class="l2">{"".join(f"<li>{a}</li>" for a in app)}</ol></div>')
    caja_per = (f'<div class="caja2"><div class="t2">{icono("usuario", 24)}<span class="sb">La persona responde con un toque, y puede saltar las preguntas</span></div>'
                f'<div class="dos"><ol class="l2">{"".join(f"<li>{q}</li>" for q in preguntas)}</ol>'
                '<div><div class="rotulo">¿Qué decidiste?</div><span class="op2">Comencé la actividad</span><span class="op2">La dejé para después</span><span class="op2">Cambié de idea</span>'
                '<div class="gris chico">Las tres con el mismo tamaño y el mismo color.</div></div></div></div>')
    logro = ('<div class="logro"><div class="sb">El ciclo se da por logrado si</div><ol>'
             '<li>el Tag suena cuando corresponde;</li><li>al oír la señal, la persona sabe qué quería hacer sin leer la pantalla y recuerda cómo empezar,</li>'
             '<li>y sigue usando Relevo durante las dos semanas.</li></ol><div class="gris chico">Una señal que falló por la conexión o por el objeto no se cuenta.</div></div>')
    css = f"""
    .linea{{display:flex;align-items:center;padding-bottom:14pt;border-bottom:2pt solid {TINTA};margin-bottom:18pt}}
    .tr{{flex:1;display:flex;align-items:center;gap:11pt;font-size:19pt}} .sep{{padding:0 14pt}}
    .cajas{{display:grid;grid-template-columns:520pt 1fr;gap:18pt}}
    .caja2{{background:{PAPEL};border-radius:16pt;padding:16pt 20pt;font-size:17pt;line-height:22pt}}
    .t2{{display:flex;align-items:center;gap:11pt;font-size:18pt;margin-bottom:12pt}}
    .l2{{padding-left:22pt;display:grid;gap:7pt}} .l2 li::marker{{font-weight:600}}
    .dos{{display:grid;grid-template-columns:1fr 250pt;gap:22pt}}
    .op{{display:block;color:{GRIS};font-size:15pt;line-height:19pt}}
    .op2{{display:block;background:#fff;border-radius:999pt;padding:5pt 12pt;margin:6pt 0;font-size:16pt;line-height:20pt;text-align:center;font-weight:500}}
    .logro{{margin-top:18pt;display:grid;grid-template-columns:250pt 1fr;column-gap:24pt;row-gap:8pt;align-items:start;background:{LUZ['Lima']};border-radius:16pt;padding:15pt 20pt;font-size:17pt;line-height:22pt}}
    .logro ol{{display:grid;grid-template-columns:1fr 1.6fr 1fr;column-gap:30pt;padding-left:20pt}} .logro .chico{{grid-column:2}}
    """
    cuerpo = f'<div class="ficha"><div class="linea">{linea}</div><div class="cajas">{caja_app}{caja_per}</div>{logro}</div>'
    return 'figura-v8-registro', cuerpo, css


# =============================================================== 7. Comparación propuesta
@figura('comparacion')
def comparacion():
    cond = {'A': ('Lima', 'lugar', 'El objeto junto al primer paso'),
            'B': ('Cielo', 'tag', 'El mismo objeto, en un lugar sin relación con la actividad'),
            'C': ('Amarillo', 'telefono', 'Una notificación genérica en el teléfono, sin la actividad escrita')}
    ordenes = ['ABC', 'ACB', 'BAC', 'BCA', 'CAB', 'CBA']
    g = '<div></div>' + ''.join(f'<div class="sem sb">Semana {k}</div>' for k in (1, 2, 3))
    for p, o in enumerate(ordenes, 1):
        g += f'<div class="per">Persona {p}</div>' + ''.join(
            f'<div class="cd" style="background:{LUZ[cond[x][0]]}"><span class="letra">{x}</span>{icono(cond[x][1], 22)}</div>' for x in o)
    ley = ''.join(f'<div class="ly"><div class="cd chica" style="background:{LUZ[c]}"><span class="letra">{k}</span></div><div>{t}</div></div>' for k, (c, _, t) in cond.items())
    notas = ('<div class="nts"><div class="nt">' + icono('suena', 22, GRIS) + '<span>El mismo sonido y las mismas preguntas en las tres condiciones.</span></div>'
             '<div class="nt">' + icono('tiempo', 22, GRIS) + '<span>Algunos relevos se cumplen sin señal, para ver cuánto se debe solo a haberlo preparado.</span></div></div>')
    css = f"""
    .fila{{display:grid;grid-template-columns:1fr 600pt;gap:40pt;align-items:center}}
    .g{{display:grid;grid-template-columns:130pt repeat(3,1fr);gap:9pt}}
    .sem{{font-size:17pt;padding:0 0 6pt 4pt;border-bottom:2pt solid {TINTA};margin-bottom:4pt}}
    .per{{font-size:17pt;color:{GRIS};font-weight:500;align-self:center}}
    .cd{{height:44pt;border-radius:12pt;display:flex;align-items:center;justify-content:center;gap:10pt}}
    .cd.chica{{width:44pt;flex:none}} .letra{{font-weight:600;font-size:19pt}}
    .der{{display:grid;gap:14pt}} .ly{{display:flex;gap:14pt;align-items:center;font-size:18pt;line-height:22pt}}
    .nts{{display:grid;gap:10pt;margin-top:8pt;padding-top:16pt;border-top:1.5pt solid {LINEA}}}
    .nt{{display:flex;gap:12pt;align-items:flex-start;color:{GRIS};font-size:16.5pt;line-height:21pt}}
    """
    cuerpo = f'<div class="ficha"><div class="fila"><div class="g">{g}</div><div class="der">{ley}{notas}</div></div></div>'
    return 'figura-v8-comparacion', cuerpo, css


if __name__ == '__main__':
    pedidas = sys.argv[1:] or list(FIGURAS)
    for clave in pedidas:
        nombre, cuerpo, css = FIGURAS[clave]()
        alto = None
        if clave == 'estados':
            alto = 400 + 60 + 2
        generar(nombre, cuerpo, css, ANCHO, alto)
