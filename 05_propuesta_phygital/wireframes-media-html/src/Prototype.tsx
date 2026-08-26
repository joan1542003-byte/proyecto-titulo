import { useEffect, useMemo, useState } from "react";
import { CheckCircledIcon, ChevronLeftIcon, ChevronRightIcon, ClockIcon, DownloadIcon, ExclamationTriangleIcon, InfoCircledIcon, Link2Icon } from "@radix-ui/react-icons";
import { MobileScroll } from "./mobile";
import { coverageFamilies, coverageStates, deliveryFrames, type CoverageState, type Mode, type Wireframe } from "./wireframes";

function readInitial() {
  const query = new URLSearchParams(window.location.search);
  const mode: Mode = query.get("mode") === "cobertura" ? "cobertura" : "entrega";
  const requested = mode === "entrega" ? query.get("frame") : query.get("state");
  const source = mode === "entrega" ? deliveryFrames : coverageStates;
  return { mode, index: Math.max(0, source.findIndex((item) => item.id === requested)) };
}

function StateIcon({ frame }: { frame: Wireframe }) {
  if (frame.visual === "error") return <ExclamationTriangleIcon />;
  if (frame.visual === "closed" || frame.visual === "ready") return <CheckCircledIcon />;
  if (frame.visual === "search" || frame.visual === "device") return <Link2Icon />;
  if (frame.visual === "arming" || frame.visual === "active") return <ClockIcon />;
  return <InfoCircledIcon />;
}

function Field({ label, value, tag = "Campo" }: { label: string; value: string; tag?: string }) {
  return <div className="ui-field"><div><span>{label}</span><small>{tag}</small></div><strong>{value}</strong></div>;
}

function WireframeBody({ frame }: { frame: Wireframe }) {
  switch (frame.id) {
    case "01": return <div className="ui-stack"><Field label="Intención" value="Por definir" tag="Campo" /><Field label="Primer paso" value="Por definir" tag="Campo" /></div>;
    case "1.1": return <div className="ui-stack"><Field label="Intención" value="Leer un capítulo" /><Field label="Primer paso" value="Abrir el libro" /></div>;
    case "1.2": return <div className="ui-stack"><Field label="Aplicación" value="Seleccionar aplicación" tag="Selector" /><Field label="Condición provisional" value="Elegir condición observable" tag="Selector" /><Field label="Vigencia" value="Hoy · 20:00–22:00" tag="Selector" /></div>;
    case "1.3": return <div className="ui-stack"><Field label="Intención" value="Leer un capítulo" tag="Resumen" /><Field label="Primer paso" value="Abrir el libro" tag="Resumen" /><Field label="Condición" value="Provisional · por validar" tag="Estado" /></div>;
    case "2.1": return <div className="ui-stack"><Field label="Testigo" value="Encontrado · listo para vincular" tag="Estado" /><Field label="Lugar elegido" value="Escritorio · junto al libro" /><p className="inline-note">El lugar se declara manualmente; Android no lo detecta.</p></div>;
    case "2.2": return <div className="ui-stack"><Field label="Vínculo" value="Conectado" tag="Estado" /><Field label="Batería" value="Suficiente para la prueba" tag="Estado" /><div className="choice-row"><span>Lo percibí</span><span>Ajustar</span></div></div>;
    case "2.3": return <div className="ui-stack"><Field label="Lugar" value="Probado" tag="Estado" /><Field label="Pulso" value="Perceptible y tolerable" tag="Estado" /><p className="inline-note">Mantener presionado el control físico para confirmar el armado provisional.</p></div>;
    case "3.1": return <div className="ui-stack"><Field label="Ciclo" value="Armado · en espera" tag="Estado" /><Field label="Intención" value="Leer un capítulo" tag="Tarjeta" /><Field label="Vigencia" value="Hasta las 22:00" tag="Estado" /></div>;
    case "3.3": return <div className="ui-stack"><Field label="Ciclo" value="Terminado · sin rearme automático" tag="Estado" /><Field label="Variante técnica" value="Revisar vínculo o comando vencido" tag="Error" /><div className="choice-row"><span>Preparar otro</span><span>Reintentar</span></div></div>;
    default: return <div className="status-card"><span>{frame.eyebrow ?? "Información crítica"}</span><strong>{frame.critical}</strong></div>;
  }
}

function FrameVisual({ frame }: { frame: Wireframe }) {
  const isPhysical = frame.visual === "physical";
  return (
    <section className={`frame-visual ${isPhysical ? "frame-visual--physical" : ""}`} aria-label={`Representación de ${frame.title}`}>
      <div className="visual-mark" aria-hidden="true"><StateIcon frame={frame} /></div>
      <p className="visual-label">{isPhysical ? "Momento situado" : frame.visual === "error" ? "Estado técnico" : "Estado del ciclo"}</p>
      <h2>{frame.title}</h2>
      <p className="visual-copy">{frame.short}</p>
      {isPhysical ? (
        <div className="physical-context">
          <div><span>Testigo</span><strong>Pulso ambiental</strong></div>
          <div><span>Lugar</span><strong>Junto al primer paso</strong></div>
          <p>El objeto emite una señal breve. No muestra texto ni registra la respuesta.</p>
        </div>
      ) : <WireframeBody frame={frame} />}
      <button className="primary-action" type="button">{frame.action}</button>
      <p className="autonomy-note">La decisión permanece en manos de la persona.</p>
    </section>
  );
}

function Sheet({ frame }: { frame: Wireframe }) {
  return (
    <details className="frame-sheet" data-testid="frame-sheet">
      <summary><InfoCircledIcon /> Ficha del wireframe <ChevronRightIcon /></summary>
      <dl>
        <div><dt>Objetivo</dt><dd>{frame.objective}</dd></div>
        <div><dt>Información</dt><dd>{frame.critical}</dd></div>
        <div><dt>Acción</dt><dd>{frame.action}</dd></div>
        <div><dt>Jerarquía</dt><dd>{frame.hierarchy}</dd></div>
        <div><dt>Error o salida</dt><dd>{frame.error}</dd></div>
      </dl>
      <div className="legend"><span>Leyenda</span>{frame.legend.split("\n").map((line) => <p key={line}>{line}</p>)}</div>
    </details>
  );
}

export default function Prototype() {
  const initial = useMemo(readInitial, []);
  const [mode, setMode] = useState<Mode>(initial.mode);
  const [index, setIndex] = useState(initial.index);
  const source = mode === "entrega" ? deliveryFrames : coverageStates;
  const frame = source[Math.min(index, source.length - 1)];
  const coverage = mode === "cobertura" ? frame as CoverageState : null;

  useEffect(() => {
    const query = new URLSearchParams();
    query.set("mode", mode);
    query.set(mode === "entrega" ? "frame" : "state", frame.id);
    window.history.replaceState(null, "", `?${query.toString()}`);
  }, [mode, frame.id]);

  const switchMode = (next: Mode) => { setMode(next); setIndex(0); };
  const move = (delta: number) => setIndex((current) => (current + delta + source.length) % source.length);
  const selectId = (id: string) => { const next = source.findIndex((item) => item.id === id); if (next >= 0) setIndex(next); };
  const groups = mode === "entrega" ? ["Interacción 1", "Interacción 2", "Interacción 3"] : coverageFamilies;
  const activeGroup = mode === "entrega" ? frame.interaction : coverage?.family;

  return (
    <MobileScroll className="relevo-scroll">
      <main className="relevo-app" data-testid="wireframe-current" data-frame-id={frame.id}>
        <header className="app-header"><div><span className="brand-mark">R</span><strong>RELEVO</strong></div><span className="fidelity">MEDIA FIDELIDAD</span></header>
        <nav className="mode-switch" aria-label="Vista de wireframes">
          <button data-testid="mode-entrega" className={mode === "entrega" ? "is-active" : ""} onClick={() => switchMode("entrega")}>Entrega · 9</button>
          <button data-testid="mode-cobertura" className={mode === "cobertura" ? "is-active" : ""} onClick={() => switchMode("cobertura")}>Cobertura · 35</button>
        </nav>
        <div className="group-rail" aria-label="Grupos">
          {groups.map((group) => {
            const first = mode === "entrega" ? deliveryFrames.find((item) => item.interaction === group) : coverageStates.find((item) => item.family === group);
            const label = mode === "entrega" ? group.replace("Interacción ", "I") : (coverageStates.find((item) => item.family === group)?.familyShort ?? group);
            return <button key={group} className={activeGroup === group ? "is-active" : ""} onClick={() => first && selectId(first.id)}>{label}</button>;
          })}
        </div>
        <div className="frame-selector" aria-label="Marcos del grupo">
          {source.filter((item) => item.interaction === frame.interaction).map((item) => <button key={item.id} className={item.id === frame.id ? "is-active" : ""} onClick={() => selectId(item.id)} aria-label={`Ver ${item.id} ${item.title}`}>{item.id}</button>)}
        </div>
        <section className="export-surface" data-testid="export-surface">
          <section className="frame-heading"><div><span>{mode === "entrega" ? frame.interaction : coverage?.family}</span><strong>{frame.id}</strong></div><p>{index + 1} de {source.length}</p></section>
          <FrameVisual frame={frame} />
          <div className="export-legend"><span>Leyenda</span>{frame.legend.split("\n").map((line) => <p key={line}>{line}</p>)}</div>
        </section>
        <Sheet frame={frame} />
        <a className="download-link" data-testid="download-frame" href={`/exports/${frame.slug}.png`} download={`${frame.slug}.png`}><DownloadIcon /> Descargar este wireframe</a>
        <nav className="frame-nav" aria-label="Navegación entre wireframes">
          <button data-testid="previous-frame" onClick={() => move(-1)}><ChevronLeftIcon /> Anterior</button>
          <button data-testid="next-frame" onClick={() => move(1)}>Siguiente <ChevronRightIcon /></button>
        </nav>
        <p className="scope-note">{mode === "entrega" ? "Tres interacciones · máximo tres marcos por interacción" : "Anexo de cobertura; no amplía la entrega principal"}</p>
      </main>
    </MobileScroll>
  );
}
