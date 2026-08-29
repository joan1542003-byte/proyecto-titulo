# Sistema visual v4

Esta versión concentra el desarrollo en aplicaciones concretas del lenguaje visual. La primera pieza fija un estándar para Android antes de extenderlo a otras pantallas, al objeto o a la memoria.

## Decisión vigente

La interfaz se construye como un instrumento de configuración y consulta, no como una aplicación de bienestar basada en tarjetas, métricas o mensajes motivacionales. La identidad surge de una retícula precisa, variaciones de densidad, tipografía de lectura y una señal cromática localizada.

La gramática visual representa tres relaciones:

1. **Intención:** un campo de información todavía concentrado.
2. **Transferencia:** una reducción gradual que relaciona la intención con un lugar.
3. **Señal situada:** un único nodo rojo asociado al testigo físico.

La secuencia no representa avance, rendimiento ni tiempo restante.

## Criterio de desarrollo

Cada pantalla se desarrolla y audita por separado. Una pieza solo puede incorporarse al sistema si:

- responde a una función documentada del flujo;
- conserva la jerarquía en escala de grises;
- utiliza el rojo en un único punto semántico;
- evita tarjetas y cápsulas sin necesidad funcional;
- mantiene texto legible y acciones reconocibles;
- distingue el estado de la aplicación de la señal que ocurre en el espacio físico.

## Contenido

- [`android/`](android/): pantallas Android aprobadas o en evaluación.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación

- **Cambio:** se abrió una versión centrada en piezas individuales y auditables.
- **Versión anterior:** el sistema v3 definía fundamentos generales y reunía exploraciones Android de calidad desigual.
- **Motivo:** evitar que una imagen panorámica o una serie generada oculte fallas de jerarquía, legibilidad y coherencia entre estados.
