import { useEffect, useMemo, useState, type CSSProperties, type ReactNode } from "react";
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

type MapType = "overview" | "route" | "coverage";

const interactionNames: Record<string, string> = {
  "1": "Formular y preparar",
  "2": "Situar, probar y armar",
  "3": "Esperar, recibir y cerrar",
};

const dotGlyphs: Record<string, string[]> = {
  R: ["11110", "10001", "10001", "11110", "10100", "10010", "10001"],
  E: ["11111", "10000", "10000", "11110", "10000", "10000", "11111"],
  L: ["10000", "10000", "10000", "10000", "10000", "10000", "11111"],
  V: ["10001", "10001", "10001", "10001", "01010", "01010", "00100"],
  O: ["01110", "10001", "10001", "10001", "10001", "10001", "01110"],
};

function readInitial() {
  const query = new URLSearchParams(window.location.search);
  const mode: Mode = query.get("mode") === "cobertura" ? "cobertura" : "entrega";
  const requested = mode === "entrega" ? query.get("frame") : query.get("state");
  const source = mode === "entrega" ? deliveryFrames : coverageStates;
  const map = query.get("view") === "mapa" ? (query.get("map") as MapType | null) : null;
  return {
    mode,
    map: map && ["overview", "route", "coverage"].includes(map) ? map : null,
    index: Math.max(0, source.findIndex((item) => item.id === requested)),
  };
}

function DotWordmark() {
  const columns: string[] = [];
  for (let row = 0; row < 7; row += 1) {
    "RELEVO".split("").forEach((letter, letterIndex) => {
      if (letterIndex > 0) columns.push("0");
      const glyph = dotGlyphs[letter];
      for (let column = 0; column < 5; column += 1) columns.push(glyph[row][column]);
    });
  }
  return (
    <span className="dot-wordmark" aria-label="Relevo">
      {columns.map((value, index) => <i key={index} className={value === "1" ? "is-on" : ""} />)}
    </span>
  );
}

function ScreenHeader({ signal = false }: { signal?: boolean }) {
  return (
    <header className={`screen-header ${signal ? "is-signal" : ""}`}>
      {signal ? <DotWordmark /> : <span className="screen-back" aria-hidden="true"><b>←</b> Atrás</span>}
      {signal ? <span className="screen-menu" aria-hidden="true">•••</span> : <DotWordmark />}
    </header>
  );
}

function Label({ children }: { children: ReactNode }) {
  return <span className="screen-label">{children}</span>;
}

function ReadRow({ label, children, muted = false }: { label?: string; children: ReactNode; muted?: boolean }) {
  return (
    <div className={`read-row ${muted ? "is-muted" : ""}`}>
      {label && <Label>{label}</Label>}
      <strong>{children}</strong>
    </div>
  );
}

function ChoiceRow({ label, children }: { label: string; children: ReactNode }) {
  return (
    <div className="choice-block">
      <Label>{label}</Label>
      <div className="choice-row"><strong>{children}</strong><span aria-hidden="true">›</span></div>
    </div>
  );
}

function ScreenActions({ primary, secondary }: { primary: string; secondary?: string }) {
  return (
    <div className="screen-actions">
      {secondary && <button type="button" className="text-action">{secondary}</button>}
      <button type="button" className="outline-action">{primary}</button>
    </div>
  );
}

function SignalField() {
  const dots = Array.from({ length: 10 * 20 }, (_, index) => {
    const row = Math.floor(index / 20);
    const column = index % 20;
    const limit = 10 + Math.abs(row - 4.5) * 1.35;
    const visible = column <= limit || (row === 5 && column === 19);
    const endpoint = row === 5 && column === 19;
    const size = Math.max(2.5, 6.6 - column * 0.2);
    const opacity = Math.max(0.25, 1 - column * 0.045);
    return (
      <i
        key={index}
        className={`${visible ? "is-visible" : ""} ${endpoint ? "is-endpoint" : ""}`}
        style={{ "--dot-size": `${endpoint ? 7 : size}px`, "--dot-opacity": endpoint ? 1 : opacity } as CSSProperties}
      />
    );
  });
  return <div className="signal-field" role="img" aria-label="La intención se reduce hasta un único punto que representa la señal situada">{dots}</div>;
}

function HoldDiagram() {
  return (
    <div className="hold-diagram" aria-label="Mantener presionado el control del testigo durante tres segundos">
      <span className="hold-ring"><i /></span>
      <div><Label>Control del testigo</Label><strong>Mantén presionado 3 s</strong><p>El ciclo queda activo cuando el vínculo confirma el armado.</p></div>
    </div>
  );
}

function DeliveryScreen({ frame }: { frame: Wireframe }) {
  switch (frame.id) {
    case "1.1":
      return (
        <div className="delivery-screen screen-formulate">
          <ScreenHeader />
          <section className="screen-heading"><Label>Formular</Label><h2>¿Qué quieres iniciar?</h2></section>
          <div className="line-fields">
            <ReadRow label="Intención">Salir a caminar</ReadRow>
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <p className="support-copy">Elige una acción concreta que puedas comenzar en el lugar.</p>
          </div>
          <ScreenActions secondary="Cancelar" primary="Continuar" />
        </div>
      );
    case "1.2":
      return (
        <div className="delivery-screen screen-condition">
          <ScreenHeader />
          <section className="screen-heading"><Label>Configurar condición</Label><h2>¿Cuándo quieres volver a considerarlo?</h2></section>
          <div className="choice-list">
            <ChoiceRow label="Aplicación">Instagram</ChoiceRow>
            <ChoiceRow label="Condición provisional">Después de 25 min de uso</ChoiceRow>
            <ChoiceRow label="Vigencia">Hoy · 20:00–22:00</ChoiceRow>
            <p className="support-copy">La condición puede cambiar antes de armar el ciclo.</p>
          </div>
          <ScreenActions secondary="Atrás" primary="Revisar ciclo" />
        </div>
      );
    case "1.3":
      return (
        <div className="delivery-screen screen-review">
          <ScreenHeader />
          <section className="screen-heading"><Label>Revisar</Label><h2>Salir a caminar</h2></section>
          <div className="review-grid">
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <ReadRow label="Condición provisional">Después de 25 min en Instagram</ReadRow>
            <ReadRow label="Vigencia">Hoy · 20:00–22:00</ReadRow>
            <div className="status-copy"><strong>El ciclo aún no está armado</strong><p>Podrás situar el testigo en el siguiente paso.</p></div>
          </div>
          <ScreenActions secondary="Editar" primary="Continuar para situar" />
        </div>
      );
    case "2.1":
      return (
        <div className="delivery-screen screen-link">
          <ScreenHeader />
          <section className="screen-heading"><Label>Situar</Label><h2>Confirma el testigo</h2><p>Comprueba que este es el que ubicaste en Dormitorio.</p></section>
          <div className="link-summary">
            <ReadRow label="Testigo">Relevo 01</ReadRow>
            <ReadRow label="Lugar">Dormitorio</ReadRow>
            <ReadRow label="Vínculo">Disponible</ReadRow>
            <ReadRow label="Batería">Suficiente para probar</ReadRow>
            <p className="support-copy">El testigo emitirá el pulso en el lugar elegido.</p>
          </div>
          <ScreenActions secondary="Elegir otro" primary="Vincular testigo" />
        </div>
      );
    case "2.2":
      return (
        <div className="delivery-screen screen-test">
          <ScreenHeader />
          <section className="screen-heading"><Label>Situar</Label><h2>Probar el pulso</h2><p>Sitúa el testigo junto al primer paso. La prueba emite una señal breve en el lugar elegido.</p></section>
          <div className="test-summary">
            <ReadRow label="Intención">Salir a caminar</ReadRow>
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <ReadRow label="Lugar">Dormitorio · declarado manualmente</ReadRow>
            <ReadRow label="Estado">Vínculo y batería disponibles</ReadRow>
            <p className="support-copy">Después de la prueba, tú indicas si el pulso se percibe o necesita ajuste.</p>
          </div>
          <ScreenActions secondary="Ajustar lugar" primary="Emitir pulso" />
        </div>
      );
    case "2.3":
      return (
        <div className="delivery-screen screen-arm">
          <ScreenHeader />
          <section className="screen-heading"><Label>Armar ciclo</Label><h2>Todo está preparado</h2><p>La intención, el lugar y el pulso fueron revisados.</p></section>
          <div className="arm-summary">
            <ReadRow label="Intención">Salir a caminar</ReadRow>
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <ReadRow label="Testigo">Relevo 01 · Dormitorio</ReadRow>
          </div>
          <HoldDiagram />
          <div className="arm-footer">
            <button type="button">Salir sin armar</button>
            <div><Label>Estado</Label><strong>Esperando confirmación</strong></div>
          </div>
        </div>
      );
    case "3.1":
      return (
        <div className="delivery-screen screen-active">
          <ScreenHeader />
          <section className="screen-heading"><Label>Ciclo activo</Label><h2>Salir a caminar</h2></section>
          <div className="active-summary">
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <ReadRow label="Condición provisional">Después de 25 min en Instagram</ReadRow>
            <ReadRow label="Vigencia">Hoy · 20:00–22:00</ReadRow>
            <ReadRow label="Testigo">Dormitorio</ReadRow>
            <div className="status-copy"><Label>Testigo vinculado</Label><p>Está listo para emitir el pulso.</p><strong>En espera</strong></div>
          </div>
          <ScreenActions primary="Desarmar ciclo" />
        </div>
      );
    case "3.2":
      return (
        <div className="delivery-screen screen-signal">
          <ScreenHeader signal />
          <section className="screen-heading"><Label>Señal situada</Label><h2>Salir a caminar</h2><p>La señal fue emitida en Dormitorio.</p></section>
          <SignalField />
          <div className="signal-summary">
            <ReadRow label="Primer paso">Ponerte las zapatillas</ReadRow>
            <ReadRow label="Testigo 01">Dormitorio</ReadRow>
          </div>
          <ScreenActions secondary="Silenciar" primary="Cerrar ciclo" />
        </div>
      );
    default:
      return (
        <div className="delivery-screen screen-closed">
          <ScreenHeader />
          <section className="screen-heading"><Label>Ciclo cerrado</Label><h2>Ciclo cerrado</h2></section>
          <div className="closed-summary">
            <ReadRow label="Intención">Salir a caminar</ReadRow>
            <ReadRow label="Estado">El ciclo terminó.</ReadRow>
            <p className="support-copy">Relevo no registra si comenzaste la actividad.</p>
            <ReadRow label="Última configuración">Ponerte las zapatillas · Dormitorio</ReadRow>
            <ReadRow label="Testigo" muted>Desvinculado</ReadRow>
          </div>
          <ScreenActions secondary="Salir" primary="Preparar otro ciclo" />
        </div>
      );
  }
}

function StateIcon({ frame }: { frame: Wireframe }) {
  if (frame.visual === "error") return <ExclamationTriangleIcon />;
  if (frame.visual === "closed" || frame.visual === "ready") return <CheckCircledIcon />;
  if (frame.visual === "search" || frame.visual === "device") return <Link2Icon />;
  if (frame.visual === "arming" || frame.visual === "active") return <ClockIcon />;
  return <InfoCircledIcon />;
}

function Field({ label, value, kind = "Contenido" }: { label: string; value: string; kind?: string }) {
  const interactive = kind === "Campo" || kind === "Selector";
  return (
    <div className={`wf-field ${interactive ? "is-interactive" : "is-informative"}`}>
      <div><span>{label}</span><small>{kind}</small></div>
      <strong>{value}</strong>
    </div>
  );
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

function CoverageCanvas({ frame }: { frame: CoverageState }) {
  return (
    <section className="wireframe-canvas coverage-canvas">
      <header className="wireframe-header"><DotWordmark /><span>{frame.id}</span></header>
      <div className="wireframe-topline"><StateIcon frame={frame} /><span>{frame.familyShort} · Estado de cobertura</span></div>
      <div className="wireframe-intro"><h2>{frame.title}</h2><p>{frame.short}</p></div>
      <div className="wireframe-content"><CoverageBody frame={frame} /></div>
      <div className="wireframe-actions"><button type="button">{frame.primary}</button><p>Este estado aparece solo cuando su condición lo requiere.</p></div>
    </section>
  );
}

function WireframeCanvas({ frame, mode }: { frame: Wireframe; mode: Mode }) {
  return (
    <article className="export-surface" data-testid="export-surface">
      {mode === "entrega" ? <DeliveryScreen frame={frame} /> : <CoverageCanvas frame={frame as CoverageState} />}
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

function MapHeader({ title, subtitle }: { title: string; subtitle: string }) {
  return <header className="map-header"><DotWordmark /><div><Label>Mapa de experiencia</Label><h1>{title}</h1><p>{subtitle}</p></div><span className="map-date">02 · 09 · 2026</span></header>;
}

function OverviewMap() {
  return (
    <main className="map-sheet map-overview" data-testid="map-export">
      <MapHeader title="Arquitectura general" subtitle="Tres interacciones principales y cinco familias de cobertura." />
      <section className="overview-route">
        {Object.entries(interactionNames).map(([number, title]) => (
          <div className="overview-stage" key={number}>
            <span>{number.padStart(2, "0")}</span><h2>{title}</h2>
            <ol>{deliveryFrames.filter((frame) => frame.id.startsWith(number)).map((frame) => <li key={frame.id}><b>{frame.id}</b>{frame.title}</li>)}</ol>
          </div>
        ))}
      </section>
      <section className="overview-principle"><SignalField /><div><Label>Momento central</Label><h2>La señal ocurre en el testigo situado.</h2><p>La aplicación registra el estado del ciclo; la persona decide qué hacer después.</p></div></section>
      <section className="overview-coverage">
        {[...new Set(coverageStates.map((state) => state.family))].map((family) => {
          const states = coverageStates.filter((state) => state.family === family);
          return <div key={family}><span>{states[0].familyShort}</span><h3>{family.replace(/^. · /, "")}</h3><p>{states[0].id}–{states.at(-1)?.id} · {states.length} estados</p></div>;
        })}
      </section>
      <footer className="map-footer"><span>Ruta principal: 9 marcos</span><span>Cobertura: 35 estados</span><span>El rojo identifica únicamente la señal situada.</span></footer>
    </main>
  );
}

function RouteMap() {
  return (
    <main className="map-sheet map-route" data-testid="map-export">
      <MapHeader title="Ruta principal" subtitle="Los nueve marcos se presentan a tamaño de lectura y en el orden del recorrido." />
      <div className="route-map-grid">
        {deliveryFrames.map((frame) => <section key={frame.id} className="route-map-frame"><header><span>{frame.id}</span><div><h2>{frame.title}</h2><p>{interactionNames[frame.id[0]]}</p></div></header><div className="map-screen-holder"><article className="export-surface"><DeliveryScreen frame={frame} /></article></div></section>)}
      </div>
    </main>
  );
}

function CoverageMap() {
  const families = [...new Set(coverageStates.map((state) => state.family))];
  return (
    <main className="map-sheet map-coverage" data-testid="map-export">
      <MapHeader title="Cobertura por familias" subtitle="Los estados complementan la ruta principal; no constituyen 35 pasos consecutivos." />
      <div className="coverage-map-columns">
        {families.map((family) => {
          const states = coverageStates.filter((state) => state.family === family);
          return <section key={family} className="coverage-family"><header><span>{states[0].familyShort}</span><div><h2>{family.replace(/^. · /, "")}</h2><p>{states.length} estados</p></div></header><ol>{states.map((state) => <li key={state.id}><b>{state.id}</b><div><h3>{state.title}</h3><p>{state.continuity}</p></div></li>)}</ol></section>;
        })}
      </div>
      <footer className="map-footer"><span>Entradas, salidas y recuperaciones</span><span>Sin rearme automático</span><span>Sin registro de cumplimiento</span></footer>
    </main>
  );
}

function MapBoard({ type }: { type: MapType }) {
  if (type === "route") return <RouteMap />;
  if (type === "coverage") return <CoverageMap />;
  return <OverviewMap />;
}

export default function Prototype() {
  const initial = useMemo(readInitial, []);
  const [mode, setMode] = useState<Mode>(initial.mode);
  const [index, setIndex] = useState(initial.index);
  const source = mode === "entrega" ? deliveryFrames : coverageStates;
  const frame = source[Math.min(index, source.length - 1)];
  const coverage = mode === "cobertura" ? frame as CoverageState : null;

  useEffect(() => {
    if (initial.map) return;
    const query = new URLSearchParams();
    query.set("mode", mode);
    query.set(mode === "entrega" ? "frame" : "state", frame.id);
    window.history.replaceState(null, "", `?${query.toString()}`);
  }, [initial.map, mode, frame.id]);

  if (initial.map) return <MapBoard type={initial.map} />;

  const switchMode = (next: Mode) => { setMode(next); setIndex(0); };
  const move = (delta: number) => setIndex((current) => (current + delta + source.length) % source.length);
  const selectId = (id: string) => { const next = source.findIndex((item) => item.id === id); if (next >= 0) setIndex(next); };

  return (
    <main className="workspace" data-testid="wireframe-current" data-frame-id={frame.id}>
      <header className="workspace-header">
        <div><DotWordmark /><p>Recorrido principal y estados de cobertura</p></div>
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
            <div><span>{index + 1} / {source.length} · {frame.id}</span><strong>{frame.title}</strong><small>{frame.id === "3.2" ? "Estado digital asociado al momento situado" : "Superficie móvil · 412 × 915 dp"}</small></div>
            <a data-testid="download-frame" href={`/exports/${frame.slug}.png`} download={`${frame.slug}.png`}><DownloadIcon /> Descargar PNG</a>
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
            <div><dt>Conjunto</dt><dd>{mode === "entrega" ? frame.interaction : coverage?.family}</dd></div>
            <div><dt>Objetivo</dt><dd>{frame.objective}</dd></div>
            <div><dt>Información crítica</dt><dd>{frame.critical}</dd></div>
            <div><dt>Acción esperada</dt><dd>{frame.action}</dd></div>
            <div><dt>Jerarquía</dt><dd>{frame.hierarchy}</dd></div>
            <div><dt>Error o salida</dt><dd>{frame.error}</dd></div>
            {coverage && <><div><dt>Disparador</dt><dd>{coverage.trigger}</dd></div><div><dt>Continuidad</dt><dd>{coverage.id} → {coverage.continuity}</dd></div></>}
          </dl>
          <div className="decision-note"><strong>Regla de representación</strong><p>Los controles del tablero permanecen fuera de la superficie móvil. El rojo aparece únicamente cuando la señal situada ya ocurrió.</p></div>
        </aside>
      </div>
    </main>
  );
}
