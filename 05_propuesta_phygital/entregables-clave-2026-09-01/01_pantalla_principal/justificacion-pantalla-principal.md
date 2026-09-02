# Pantalla principal: ciclo activo en espera

## Decisión

La pantalla más importante de la aplicación es **Ciclo activo en espera**. No es la portada ni el formulario inicial: es el estado que confirma que la intención ya fue configurada, vinculada a un primer paso y situada mediante el testigo. También representa el límite funcional de la aplicación, porque el siguiente acontecimiento relevante debe ocurrir en el entorno.

## Por qué concentra el valor del sistema

La vista reúne la información mínima necesaria para comprender qué quedó preparado:

- la intención elegida;
- el primer paso que permite comenzarla;
- la condición provisional de activación;
- la vigencia temporal;
- el lugar del testigo y la disponibilidad del vínculo;
- la posibilidad de desarmar el ciclo.

Esta jerarquía mantiene el control en la persona. La pantalla no muestra un contador, no promete que la actividad comenzará, no registra cumplimiento y no transforma la espera en progreso. La frase `El testigo espera fuera de la pantalla` aclara la distribución phygital: Android organiza y confirma; el testigo emite la señal en el lugar elegido.

## Decisiones de interfaz

1. **Una sola columna.** Favorece un recorrido estable de arriba abajo y evita que datos equivalentes compitan entre sí.
2. **Intención como encabezado principal.** La configuración técnica queda subordinada a aquello que la persona desea recuperar.
3. **Filas separadas por reglas.** La información se agrupa por relación semántica, sin convertir cada dato en una tarjeta independiente.
4. **Acción destructiva al final.** `Desarmar ciclo` permanece disponible, pero se separa del contenido para reducir activaciones accidentales.
5. **Ausencia de rojo.** Todavía no existe una señal situada. Usar el rojo antes de ese momento debilitaría su significado y podría confundirse con selección o estado activo.
6. **Puntos solo en la marca.** No se utilizan como progreso, paginación o control. La lectura funcional recae en tipografía continua.
7. **Modo oscuro.** Es el contrato vigente para Android y permite diferenciar la interfaz de la publicación editorial, sin convertir el tema en un argumento de eficacia.

## Qué demuestra la imagen y qué no

La imagen demuestra una dirección de jerarquía, composición, tipografía y lenguaje. No comprueba comprensión, accesibilidad con TalkBack, escalado tipográfico, funcionamiento en distintos tamaños, respuesta táctil ni comportamiento técnico del vínculo. Esas condiciones deben verificarse en un prototipo interactivo.

## Fuentes de decisión

- `08_memoria/memoria-vigente-v4.md`, apartados 10 y 11.
- `05_propuesta_phygital/wireframes-media-html/`, marco 3.1 y estado 20.
- `10_recursos_visuales/08_direccion_visual_relevo/sistema-v4/manual-sistema-visual-relevo.md`.
- Norman, D. A. (2013). *The design of everyday things* (Rev. and expanded ed.). Basic Books.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Pantalla de alta fidelidad

- **Cambio:** se seleccionó y desarrolló `Ciclo activo en espera` como pantalla principal.
- **Situación anterior:** existían referencias visuales del flujo, pero ninguna quedaba presentada como síntesis prioritaria de la propuesta.
- **Motivo:** representar el momento en que la aplicación termina de organizar la intención y cede el acontecimiento principal al entorno físico.
