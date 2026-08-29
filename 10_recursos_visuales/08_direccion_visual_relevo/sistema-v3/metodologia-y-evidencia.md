# Metodología y evidencia del sistema visual

## Método de desarrollo

El sistema se desarrolla mediante una adaptación del Doble Diamante del Design Council. En **descubrir** se revisan la memoria, las entrevistas, los wireframes, los referentes y las restricciones del proyecto. En **definir** se separan principios transferibles de preferencias formales y se formula una gramática propia. En **desarrollar** se producen alternativas comparables en claro y oscuro. En **entregar** se sistematizan tokens, componentes, retículas y criterios de prueba. El proceso admite retornos: una prueba puede reabrir una decisión sin desordenar el registro.

La interfaz se descompone desde fundamentos hasta estados reutilizables. Los valores compartidos se registran como *tokens de diseño*: nombres asociados a decisiones como color, tamaño o espaciado. La especificación del Design Tokens Community Group permite mantener un vocabulario independiente de la herramienta y trasladarlo después a Figma o código.

## Cuatro tipos de respaldo

Cada decisión debe declarar qué la sostiene. No son equivalentes:

1. **Evidencia del proyecto:** memoria, entrevistas, flujo y restricciones documentadas.
2. **Estándar o guía profesional:** WCAG 2.2, Android, Material 3, APA 7 o DTCG.
3. **Principio teórico o empírico:** carga cognitiva, ley de Fitts o relación entre cantidad de alternativas y tiempo de elección.
4. **Hipótesis de diseño:** una decisión razonable que todavía debe comprobarse con personas, impresión o prototipos.

Una metodología ordena el proceso; no demuestra por sí sola que una solución funcione. Del mismo modo, las Laws of UX se usan como heurísticas de revisión y se conectan con sus fuentes, no como garantías automáticas de usabilidad.

## Secuencia de evaluación

1. auditoría experta contra el flujo y las reglas del repositorio;
2. comprobación de contraste, tamaño, escalamiento y estados;
3. recorrido cognitivo sobre las tareas principales;
4. prueba de lectura y navegación con los dos tipos de usuario;
5. prueba situada de convivencia entre aplicación, objeto y señal;
6. registro de hallazgos, decisión y cambio.

## Fuentes de método y criterios

- Design Council. (s. f.). *Framework for innovation*. https://www.designcouncil.org.uk/resources/framework-for-innovation/
- Design Tokens Community Group. (2025). *Design Tokens Format Module 2025.10*. https://www.designtokens.org/TR/2025.10/format/
- Fitts, P. M. (1954). The information capacity of the human motor system in controlling the amplitude of movement. *Journal of Experimental Psychology, 47*(6), 381–391. https://doi.org/10.1037/h0055392
- Google. (2026). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility
- Google. (2026). *Material Design 3 in Compose*. Android Developers. https://developer.android.com/develop/ui/compose/designsystems/material3
- Sweller, J. (1988). Cognitive load during problem solving: Effects on learning. *Cognitive Science, 12*(2), 257–285. https://doi.org/10.1207/s15516709cog1202_4
- World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

---

## Registro de cambios (disclaimer)

### 2026-08-28 — Creación

- **Cambio:** se definió un método de desarrollo y una jerarquía explícita de evidencias.
- **Versión anterior:** las fuentes justificaban reglas aisladas, pero no existía un protocolo común para cerrar o reabrir decisiones.
- **Motivo:** distinguir respaldo metodológico, evidencia y preferencia antes de diseñar nuevas piezas.

