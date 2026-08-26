# Wireframes HTML de media fidelidad — Relevo

## Resultado

Este prototipo traduce el Encargo 17 y la memoria vigente v4 a una experiencia HTML navegable. Mantiene dos niveles separados:

1. **Entrega:** tres interacciones y nueve marcos evaluables, con un máximo de tres marcos por interacción.
2. **Cobertura:** 35 estados complementarios que hacen visibles validaciones, salidas voluntarias, fallos técnicos y estados límite.

Cada marco puede descargarse como PNG. Las 44 exportaciones vigentes se encuentran en [`public/exports`](public/exports/) y su correspondencia está registrada en [`manifest.json`](public/exports/manifest.json).

## Criterio visual

La interfaz mantiene media fidelidad y una paleta monocromática. Las referencias Nothing, Material Design e iOS 26 se traducen en ritmo, jerarquía, superficies ligeras y controles legibles; no se presentan como identidad visual final. El prototipo conserva Android como plataforma técnica inicial y evita imitar literalmente una interfaz de sistema operativo.

## Coherencia con Relevo

- La aplicación organiza intención, primer paso, condición provisional, vínculo, vigencia y estados técnicos.
- El momento 3.2 representa un pulso físico situado; no es una pantalla instalada en el testigo.
- El objeto no contiene texto, menú, historial ni interfaz de consulta.
- La persona puede iniciar, continuar, ignorar, silenciar, cambiar de idea o cerrar sin registro de cumplimiento.
- Condición, señal, gesto y forma física permanecen como decisiones sujetas a prototipado.

## Archivos centrales

- [`COBERTURA.md`](COBERTURA.md): arquitectura de 9 + 35 marcos y checklist de pauta.
- [`src/wireframes.ts`](src/wireframes.ts): contenido estructurado de todos los marcos.
- [`src/Prototype.tsx`](src/Prototype.tsx): navegación e interfaz.
- [`src/prototype.css`](src/prototype.css): sistema visual de media fidelidad.
- [`scripts/export-wireframes.mjs`](scripts/export-wireframes.mjs): exportación individual de PNG.
- [`design-qa.md`](design-qa.md): auditoría visual, funcional y técnica.

## Verificación

La versión vigente superó comprobación de runtime, TypeScript, navegación, ficha desplegable, existencia de las 44 descargas, desborde horizontal, consola del navegador, build de producción y pruebas de empaquetado.

---

## Registro de creación

**26 de agosto de 2026.** Se creó el prototipo HTML de media fidelidad a partir de la memoria vigente v4, la pauta del Encargo 17, el anexo de 35 estados y las referencias visuales 4K. Antes solo existían el tablero Figma y láminas para reconstrucción. La versión HTML permite recorrer y descargar cada marco sin agregar funciones al producto ni acreditar validación de la experiencia.
