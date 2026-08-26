# Prototype Instructions

Run the local server yourself and open the preview in the browser available to this environment. Do not give the user server-start instructions when you can run it.

Before making substantial visual changes, use the Product Design plugin's `get-context` skill when the visual source is unclear or no longer matches the current goal. When the user gives durable prototype-specific design feedback, preferences, or decisions, record them in `AGENTS.md`.

When implementing from a selected generated mock, treat that image as the source of truth for layout, component anatomy, density, spacing, color, typography, visible content, and hierarchy.

Build app UI in `src/`. Keep `.openai/hosting.json`, `worker/index.js`, `scripts/prepare-sites-build.mjs`, and `tests/sites-worker.test.mjs` intact so the same local prototype can be handed to Sites. Before a Sites handoff, run `npm run build` and `npm run test:sites`; the build must leave `dist/client/index.html`, `dist/server/index.js`, and `dist/.openai/hosting.json`.

## Relevo — contrato del tablero

- La referencia visual obligatoria es `design-reference.png`.
- El tablero es una herramienta de presentación del Encargo 17; no es una función de Relevo.
- Dentro del teléfono solo aparece el contenido del wireframe seleccionado.
- Catálogo, identificación, explicación, objetivo, información crítica, acción, jerarquía, error, componentes, leyenda, correspondencia con la pauta y descarga viven fuera del teléfono.
- Deben permanecer separados `Entrega principal · 9` y `Anexo documental · 35`.
- El marco 3.2 representa un momento físico situado y nunca una interfaz instalada en el testigo.
- El lenguaje visual es monocromático cálido, editorial y de media fidelidad; no imita Android ni iOS.
