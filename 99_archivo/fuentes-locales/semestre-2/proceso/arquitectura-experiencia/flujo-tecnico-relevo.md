---
id: FL-S2-PROC-AE-001
titulo: "Ficha histórica del flujo técnico de Relevo"
autoria: propia
estado_documental: histórico
familia_documental: "arquitectura de experiencia"
sensibilidad: interna
fuente_sha256: 5ddff59a468b42ba1684fe50f5ebbb31d12e46f50f529ae1be08400219d322f1
duplicado_exacto: false
fuentes_locales_relativas:
  - "SEMESTRE 2/output/Encargo 16 - 11 mapas horizontales - FINAL/Ficha técnica - cumplimiento Encargo 16.md"
metodo_conversion: "copia estructural desde Markdown con correcciones factuales declaradas"
fecha_migracion: 2026-08-23
---

# Ficha histórica del flujo técnico de Relevo

## Nota archivística

Este documento registra una iteración de producción o entrega. Sus rótulos internos se conservan por procedencia, pero no deben trasladarse a la memoria final como referencias a un encargo.

## Contenido migrado

# Flujo técnico · Relevo

## Cumplimiento del detalle requerido

La lámina técnica documenta el recorrido completo y separa los comportamientos del software de las respuestas del objeto físico sin convertirlos en funciones ya validadas. Las cifras son metas de prototipo y deben comprobarse mediante pruebas.

### Software

| Requisito del encargo | Decisión documentada | Estado |
|---|---|---|
| Permisos de sistema | La aplicación solicita acceso al uso del teléfono. Si el permiso se revoca, la regla se pausa y se solicita volver a Ajustes. | Por validar en Android objetivo |
| Error de conexión | Si el vínculo Bluetooth no está disponible, se reintenta y se avisa. | Por validar |
| Recuperación de credenciales/vínculo | El MVP no usa cuenta ni contraseña. Si se pierde el vínculo, se vuelve a asociar Relevo mediante Bluetooth. | Por validar |
| Condición no detectada | La aplicación espera y no activa tarde; puede emitir un aviso de respaldo. | Por validar |
| Tiempos de respuesta | Meta: abrir configuración en ≤ 2 s y establecer conexión en ≤ 10 s. | Por medir |
| Estado devuelto | El objeto envía señal terminada y batería. La aplicación conserva estado técnico, nunca cumplimiento de la persona. | Por implementar y verificar |

### Hardware y materialidad

| Requisito del encargo | Decisión documentada | Estado |
|---|---|---|
| Iluminación LED | Halo breve de 2 s, con intensidad regulable por perfil. | Por medir en distintas condiciones de luz |
| Sonido | Tono breve de aproximadamente 300 ms; puede desactivarse. | Por medir en la carcasa |
| Vibración | Dos pulsos de aproximadamente 180 ms mediante actuador lineal. | Por probar sobre madera, tela y zapatillas |
| Pulsación de vinculación | Mantener botón 2 s para vincular/armar; pulsación breve para probar o silenciar. | Por validar con usuarios |
| Respuesta mecánica | Actuador lineal, botón táctil y apoyo TPE antideslizante; el acople depende de la superficie. | Por prototipar |
| Sensores | No se incorporan GPS ni sensores ambientales. El estado mínimo es botón, batería y conexión. | Decisión de alcance |
| Tolerancias de material | Meta inicial: Ø44 ± 0,5 mm; espesor 14 ± 0,5 mm; TPE ± 0,3 mm. | Por verificar con CAD y prototipo |
| Energía | Batería Li-Po interna y recarga USB-C; si la batería es baja, no se activa la señal. | Por medir autonomía y tiempo de recarga |

## Cadena física–digital

La secuencia que debe conservarse en la implementación es:

**intención → regla local → permiso → vínculo → condición → orden de señal → recepción en Relevo → luz/sonido/vibración → apagado o silencio → acuse técnico**.

La señal no registra si la persona cumplió la acción. Relevo devuelve una oportunidad de recuperación situada; la decisión sigue siendo de la persona.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Migración y clasificación

- **Cambio realizado:** se trasladó una fuente Markdown local a una ruta funcional del archivo histórico.
- **Estado anterior:** el documento estaba organizado por paquete de entrega y no por función, versión o vigencia.
- **Motivo:** conservar el proceso sin convertir una entrega visual anterior en definición actual del proyecto.
- **Duplicación:** no se detectó otra copia exacta dentro de los 21 Markdown auditados.
- **Originales:** ningún archivo local fue editado, movido ni eliminado.
- **Correcciones factuales:** no se detectaron en esta fuente las formulaciones metodológicas o de autoría definidas para sustitución.
- **Criterio de uso:** toda decisión contenida aquí debe contrastarse con la memoria y la investigación activas antes de reutilizarse.
