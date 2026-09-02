import { useEffect, useMemo, useState } from "react";
import {
  CheckCircledIcon,
  ChevronLeftIcon,
  ChevronRightIcon,
  ClockIcon,
  DownloadIcon,
  ExclamationTriangleIcon,
  InfoCircledIcon,
  Link2Icon,
} from "@radix-ui/react-icons";
import {
  coverageStates,
  deliveryFrames,
  type CoverageState,
  type Mode,
  type Wireframe,
} from "./wireframes";

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

function Field({ label, value, kind = "Contenido" }: { label: string; value: string; kind?: string }) {
  return (
    <div className="wf-field">
      <div><span>{label}</span><small>{kind}</small></div>
      <strong>{value}</strong>
    </div>
  );
}

function DeliveryBody({ frame }: { frame: Wireframe }) {
  switch (frame.id) {
    case "1.1":
      return <div className="wf-stack"><Field label="Intención" value="Leer un capítulo" kind="Campo" /><Field label="Primer paso" value="Abrir el libro" kind="Campo" /></div>;
    case "1.2":
      return <div className="wf-stack"><Field label="Aplicación" value="Seleccionar aplicación" kind="Selector" /><Field label="Condición provisional" value="Elegir condición observable" kind="Selector" /><Field label="Vigencia" value="Hoy · 20:00–22:00" kind="Selector" /></div>;
    case "1.3":
      return <div className="wf-stack"><Field label="Intención" value="Leer un capítulo" kind="Resumen" /><Field label="Primer paso" value="Abrir el libro" kind="Resumen" /><Field label="Condición" value="Provisional · por validar" kind="Estado" /></div>;
    case "2.1":
      return <div className="wf-stack"><Field label="Testigo" value="Encontrado · listo para vincular" kind="Estado" /><Field label="Lugar elegido" value="Escritorio · junto al libro" /><p className="wf-note">El lugar se declara manualmente.</p></div>;
    case "2.2":
      return <div className="wf-stack"><Field label="Vínculo" value="Conectado" kind="Estado" /><Field label="Batería" value="Suficiente para la prueba" kind="Estado" /><div className="wf-choices"><span>Lo percibí</span><span>Necesita ajuste</span></div></div>;
    case "2.3":
      return <div className="wf-stack"><Field label="Lugar" value="Probado" kind="Estado" /><Field label="Pulso" value="Perceptible y tolerable" kind="Estado" /><p className="wf-note">El armado requiere una confirmación física deliberada.</p></div>;
    case "3.1":
      return <div className="wf-stack"><Field label="Ciclo" value="Armado · en espera" kind="Estado" /><Field label="Intención" value="Leer un capítulo" /><Field label="Vigencia" value="Hasta las 22:00" kind="Estado" /></div>;
    case "3.3":
      return <div className="wf-stack"><Field label="Ciclo" value="Terminado · sin rearme automático" kind="Estado" /><Field label="Variante técnica" value="Revisar vínculo o comando vencido" kind="Recuperación" /><div className="wf-choices"><span>Preparar otro</span><span>Reintentar</span></div></div>;
    default:
      return <Field label="Información crítica" value={frame.critical} />;
  }
}

function CoverageBody({ frame }: { frame: CoverageState }) {
  return (
    <div className="wf-stack">
      <Field label="Condición de entrada" value={frame.trigger} kind="Estado" />
      <Field label="Información crítica" value={frame.critical} />
      <div className="wf-continuity"><span>Continuidad documentada</span><strong>{frame.id} → {frame.continuity}</strong></div>
      {frame.secondary.length > 0 && <div className="wf-choices">{frame.secondary.slice(0, 2).map((item) => <span key={item}>{item}</span>)}</div>}
    </div>
  );
}

function PhysicalBody({ frame }: { frame: Wireframe }) {
  return (
    <div className="physical-map" aria-label="Relación entre testigo, lugar y primer paso">
      <div className="physical-node"><span>Testigo</span><strong>Pulso ambiental</strong></div>
      <div className="physical-link" aria-hidden="true"><i /></div>
      <div className="physical-node"><span>Lugar</span><strong>Junto al primer paso</strong></div>
      <p>{frame.critical}</p>
    </div>
  );
}

function WireframeCanvas({ frame, mode }: { frame: Wireframe; mode: Mode }) {
  const coverage = mode === "cobertura" ? frame as CoverageState : null;
  const physical = frame.visual === "physical";
  return (
    <article className="export-surface" data-testid="export-surface">
      <header className="export-header">
        <div><span>{physical ? "MOMENTO FÍSICO" : "CAPA DIGITAL"}</span><strong>{frame.id}</strong></div>
        <p>{mode === "entrega" ? frame.interaction : coverage?.family}</p>
      </header>

      <section className={`wireframe-canvas ${physical ? "is-physical" : ""}`}>
        <div className="wireframe-topline"><StateIcon frame={frame} /><span>{frame.eyebrow ?? (physical ? "Señal situada" : "Estado del ciclo")}</span></div>
        <div className="wireframe-intro"><h2>{frame.title}</h2><p>{frame.short}</p></div>
        <div className="wireframe-content">
          {physical ? <PhysicalBody frame={frame} /> : coverage ? <CoverageBody frame={coverage} /> : <DeliveryBody frame={frame} />}
        </div>
        {physical ? (
          <div className="wireframe-actions physical-responses"><p><strong>Respuestas válidas</strong>Iniciar · continuar · ignorar · silenciar</p><p>Ninguna respuesta se registra como cumplimiento.</p></div>
        ) : (
          <div className="wireframe-actions"><button type="button">{mode === "cobertura" ? coverage?.primary : frame.action.split(".")[0]}</button><p>La persona puede salir o cambiar de decisión.</p></div>
        )}
      </section>

      <footer className="export-legend">
        <span>LECTURA DEL MARCO</span>
        <p>{frame.objective}</p>
        <dl><div><dt>Jerarquía</dt><dd>{frame.hierarchy}</dd></div><div><dt>Error o salida</dt><dd>{frame.error}</dd></div></dl>
      </footer>
    </article>
  );
}

function FrameCatalog({ source, frame, selectId }: { source: Wireframe[]; frame: Wireframe; selectId: (id: string) => void }) {
  const groups = [...new Set(source.map((item) => item.interaction))];
  return (
    <div className="catalog-list">
      {groups.map((group) => (
        <section key={group}>
          <h3>{group}</h3>
          {source.filter((item) => item.interaction === group).map((item) => (
            <button key={item.id} className={item.id === frame.id ? "is-active" : ""} onClick={() => selectId(item.id)}>
              <span>{item.id}</span><strong>{item.title}</strong>
            </button>
          ))}
        </section>
      ))}
    </div>
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

  return (
    <main className="workspace" data-testid="wireframe-current" data-frame-id={frame.id}>
      <header className="workspace-header">
        <div><span className="wordmark">RELEVO</span><p>Wireframes HTML · estructura antes que apariencia</p></div>
        <div className="mode-switch" aria-label="Conjunto de wireframes">
          <button data-testid="mode-entrega" className={mode === "entrega" ? "is-active" : ""} onClick={() => switchMode("entrega")}>Ruta principal <span>9</span></button>
          <button data-testid="mode-cobertura" className={mode === "cobertura" ? "is-active" : ""} onClick={() => switchMode("cobertura")}>Cobertura <span>35</span></button>
        </div>
      </header>

      <div className="workspace-grid">
        <aside className="catalog" aria-label="Catálogo de wireframes">
          <div className="panel-heading"><span>01</span><div><h2>Catálogo</h2><p>Selecciona un marco</p></div></div>
          <FrameCatalog source={source} frame={frame} selectId={selectId} />
        </aside>

        <section className="canvas-panel">
          <div className="canvas-toolbar">
            <div><span>{index + 1} / {source.length}</span><strong>{frame.title}</strong></div>
            <a data-testid="download-frame" href={`/exports/${frame.slug}.png`} download={`${frame.slug}.png`}><DownloadIcon /> Exportar PNG</a>
          </div>
          <WireframeCanvas frame={frame} mode={mode} />
          <nav className="frame-nav" aria-label="Navegación entre wireframes">
            <button data-testid="previous-frame" onClick={() => move(-1)}><ChevronLeftIcon /> Anterior</button>
            <button data-testid="next-frame" onClick={() => move(1)}>Siguiente <ChevronRightIcon /></button>
          </nav>
        </section>

        <aside className="rationale" aria-label="Fundamento del wireframe">
          <div className="panel-heading"><span>03</span><div><h2>Fundamento</h2><p>Decisiones verificables</p></div></div>
          <dl>
            <div><dt>Objetivo</dt><dd>{frame.objective}</dd></div>
            <div><dt>Información crítica</dt><dd>{frame.critical}</dd></div>
            <div><dt>Acción esperada</dt><dd>{frame.action}</dd></div>
            <div><dt>Jerarquía</dt><dd>{frame.hierarchy}</dd></div>
            <div><dt>Error o salida</dt><dd>{frame.error}</dd></div>
            {coverage && <><div><dt>Disparador</dt><dd>{coverage.trigger}</dd></div><div><dt>Continuidad</dt><dd>{coverage.id} → {coverage.continuity}</dd></div></>}
          </dl>
          <div className="decision-note"><strong>Regla de representación</strong><p>El marco muestra estructura, estado y salida. No simula hardware, no fija identidad visual y no convierte el momento físico en pantalla.</p></div>
        </aside>
      </div>
    </main>
  );
}
