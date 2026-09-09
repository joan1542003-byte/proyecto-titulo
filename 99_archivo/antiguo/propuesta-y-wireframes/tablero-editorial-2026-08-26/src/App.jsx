import { useMemo, useState } from "react";
import { DownloadIcon, ChevronLeftIcon, ChevronRightIcon, CheckIcon, Cross2Icon } from "@radix-ui/react-icons";
import { toPng } from "html-to-image";
import { deliveryFrames, coverageStates, coverageFamilies } from "./data";
import "./styles.css";

const params = new URLSearchParams(location.search);
const initialMode = params.get("mode") === "cobertura" ? "cobertura" : "entrega";
const initialKey = initialMode === "entrega" ? (params.get("frame") || "1.1") : (params.get("state") || "01").padStart(2, "0");

function PhoneScreen({ item, physical = false }) {
  if (physical) {
    return <div className="physical-scene" data-testid="wireframe-export">
      <div className="scene-copy"><span>ESCENA SITUADA</span><h2>Un pulso junto al primer paso</h2><p>El testigo permanece en el espacio elegido. La decisión continúa en manos de la persona.</p></div>
      <div className="desk"><div className="notebook"><i/><i/><i/></div><div className="witness"><b/><em>pulso</em></div><div className="cup"/></div>
      <div className="scene-actions"><span>Iniciar</span><span>Continuar</span><span>Ignorar</span><span>Silenciar</span></div>
    </div>;
  }
  const visual = item.visual;
  return <div className="phone" data-testid="wireframe-export"><div className="phone-slot"/><div className="phone-screen" data-testid="phone-content">
    <header className="app-head"><button aria-label="Volver"><ChevronLeftIcon/></button><span>RELEVO</span><small>{item.id}</small></header>
    <main className="app-body">
      <p className="eyebrow">{item.interaction.split("·").at(-1)}</p><h2>{item.title}</h2><p className="lead">{item.short}</p>
      {visual === "form" && <><label>Intención</label><div className="field">Leer veinte minutos</div><label>Primer paso</label><div className="field">Dejar el libro sobre el escritorio</div></>}
      {["review","ready","arming","active"].includes(visual) && <div className="stack"><article><small>INTENCIÓN</small><b>Leer veinte minutos</b></article><article><small>PRIMER PASO</small><b>Abrir el libro marcado</b></article><article><small>VIGENCIA</small><b>Hoy · hasta las 21:30</b></article></div>}
      {["device","search","test"].includes(visual) && <><div className="object-card"><div className="object-dot"/><div><small>TESTIGO RELEVO</small><b>{visual === "search" ? "Buscando…" : "Listo para vincular"}</b></div></div><div className="place-card"><small>LUGAR ELEGIDO</small><b>Escritorio · junto al libro</b><p>La ubicación se declara manualmente.</p></div></>}
      {visual === "error" && <div className="notice"><Cross2Icon/><div><b>Estado técnico recuperable</b><p>{item.error}</p></div></div>}
      {visual === "closed" && <div className="closing"><CheckIcon/><h3>Ciclo terminado</h3><p>No es necesario demostrar que la actividad se realizó.</p></div>}
      {visual === "decision" && <div className="choice-grid"><button>Iniciar</button><button>Continuar</button><button>Ignorar</button><button>Silenciar</button></div>}
    </main>
    <footer className="app-actions"><button className="primary">{item.primary || item.action}</button>{(item.secondary || ["Volver"]).slice(0,2).map(x=><button key={x}>{x}</button>)}</footer>
  </div></div>;
}

export function App() {
  const [mode, setMode] = useState(initialMode);
  const [key, setKey] = useState(initialKey);
  const items = mode === "entrega" ? deliveryFrames : coverageStates;
  const item = useMemo(() => items.find(x => x.id === key) || items[0], [items, key]);
  const index = items.indexOf(item);
  const choose = (nextMode, nextKey) => { setMode(nextMode); setKey(nextKey); history.replaceState(null,"", nextMode === "entrega" ? `?mode=entrega&frame=${nextKey}` : `?mode=cobertura&state=${nextKey}`); };
  const move = d => choose(mode, items[(index+d+items.length)%items.length].id);
  const download = async () => { const node=document.querySelector('[data-testid="wireframe-export"]'); const url=await toPng(node,{pixelRatio:2,backgroundColor:"#f4f1ea"}); const a=document.createElement("a"); a.download=`relevo-${mode}-${item.id}.png`;a.href=url;a.click(); };
  const groups = mode === "entrega" ? [...new Set(deliveryFrames.map(x=>x.interaction))] : coverageFamilies;
  return <div className="board" data-testid="board">
    <header className="topbar"><div><b>RELEVO</b><span>Archivo de wireframes · Encargo 17</span></div><div className="counts"><span>Entrega principal <b>9</b></span><i/><span>Anexo documental <b>35</b></span></div></header>
    <div className="layout">
      <aside className="catalog" data-testid="catalog">
        <div className="mode-switch"><button data-testid="mode-entrega" className={mode==="entrega"?"on":""} onClick={()=>choose("entrega","1.1")}>Entrega</button><button data-testid="mode-cobertura" className={mode==="cobertura"?"on":""} onClick={()=>choose("cobertura","01")}>Cobertura</button></div>
        <p className="section-label">CATÁLOGO</p>
        <nav>{groups.map(group=><section key={group}><h3>{group}</h3>{items.filter(x => mode==="entrega" ? x.interaction===group : x.family===group).map(x=><button className={x.id===item.id?"selected":""} onClick={()=>choose(mode,x.id)} key={x.id}><span>{x.id}</span><div><b>{x.title}</b><small>{x.short}</small></div></button>)}</section>)}</nav>
      </aside>
      <main className="exhibition"><div className="frame-meta"><span>WIRE­FRAME {index+1} / {items.length}</span><span>{mode === "entrega" ? "ENTREGA PRINCIPAL" : "ANEXO DOCUMENTAL"}</span></div><div className="canvas">{item.visual === "physical" ? <PhoneScreen item={item} physical/> : <PhoneScreen item={item}/>}</div><div className="pager"><button onClick={()=>move(-1)}><ChevronLeftIcon/>Anterior</button><div>{items.map((_,i)=><i className={i===index?"active":""} key={i}/>)}</div><button onClick={()=>move(1)}>Siguiente<ChevronRightIcon/></button></div></main>
      <aside className="inspector" data-testid="inspector"><div className="sheet-head"><span>FICHA {item.id}</span><b>{mode === "entrega" ? "MEDIA FIDELIDAD" : "ESTADO DE COBERTURA"}</b></div><h1>{item.title}</h1><p className="summary">{item.short}</p>
        <Info title="Objetivo" text={item.objective}/><Info title="Información crítica" text={item.critical}/><Info title="Acción principal" text={item.primary || item.action}/><Info title="Jerarquía" text={item.hierarchy}/><Info title="Error o salida" text={item.error}/>
        <section className="legend"><h3>Lectura del wireframe</h3>{item.legend.split("\n").map(x=><p key={x}>{x}</p>)}</section>
        <section className="assignment"><h3>Correspondencia con Encargo 17</h3><p><b>{mode === "entrega" ? "Flujo principal" : "Cobertura de estados"}</b></p><p>Explicita objetivo, contenido, jerarquía, acción y salida sin convertir el testigo físico en una pantalla.</p></section>
        <button className="download" data-testid="download-frame" onClick={download}><DownloadIcon/>Descargar wireframe PNG</button>
      </aside>
    </div>
  </div>;
}

function Info({title,text}) { return <section className="info"><h3>{title}</h3><p>{text}</p></section>; }
export default App;
