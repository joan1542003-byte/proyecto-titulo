# Alcance del primer prototipo y backlog

**Fecha de corte:** 7 de septiembre de 2026

**Propósito:** definir qué debe construirse primero y qué puede esperar, sin reducir la cobertura documentada del sistema.

## Decisión de alcance

Los 35 estados de Relevo permiten anticipar recorridos normales, salidas voluntarias y fallos. No es necesario implementarlos todos para comprobar la primera pregunta del proyecto. El primer prototipo debe demostrar un ciclo completo y comprensible: formular una intención, asociarla con un primer paso y un lugar, preparar la señal, esperar, recibir el pulso y cerrar.

El término **primer prototipo** se refiere aquí a la versión mínima que permite recorrer y revisar esa relación. No es el producto final ni una versión comercial. Su función es descubrir problemas de comprensión y funcionamiento antes de invertir tiempo en variantes secundarias.

## Recorrido imprescindible

| Orden | Marco | Qué debe permitir | Razón de inclusión |
| --- | --- | --- | --- |
| 1 | 1.1 Formular | Escribir una intención y un primer paso concreto. | Sin una intención propia no existe el ciclo que Relevo busca recuperar. |
| 2 | 1.2 Configurar | Elegir una condición provisional y una vigencia. | Hace explícito cuándo podría emitirse la señal, sin presentar la condición como validada. |
| 3 | 1.3 Revisar | Corregir o confirmar los datos del ciclo. | Previene asociaciones involuntarias y errores antes de situar el testigo. |
| 4 | 2.1 Situar | Asociar el testigo con un lugar cercano al primer paso. | Permite probar si el lugar aporta significado a la señal. |
| 5 | 2.2 Probar | Emitir y detener un pulso de prueba. | Comprueba percepción y molestia antes de armar el ciclo. |
| 6 | 2.3 Armar | Confirmar de forma explícita que el ciclo queda activo. | Evita activaciones ambiguas y mantiene el control en la persona. |
| 7 | 3.1 Esperar | Mostrar vigencia, estado y opción de desarmar. | Hace comprensible que el sistema está activo sin exigir atención constante. |
| 8 | 3.2 Recibir | Emitir el pulso desde el testigo situado. | Es el momento que permite estudiar el aporte físico de Relevo. |
| 9 | 3.3 Cerrar | Silenciar, cerrar o recuperar un fallo básico. | El ciclo necesita una salida clara y no punitiva. |

El marco 3.2 no es una pantalla del objeto. En una demostración puede representarse mediante una lámina contextual, pero en el prototipo corresponde al pulso físico.

## Estados críticos de recuperación

La primera construcción debe resolver pocos fallos, pero no puede mostrar únicamente el caso ideal. Se priorizan:

1. datos incompletos;
2. salida voluntaria antes de armar;
3. testigo no disponible;
4. señal no percibida o demasiado intrusiva durante la prueba;
5. confirmación ambigua del armado;
6. desarme voluntario;
7. vencimiento sin activación;
8. cierre después de silenciar o ignorar la señal.

Estos estados protegen comprensión, autonomía y posibilidad de recuperación. Los demás continúan documentados en el anexo y se incorporarán cuando la arquitectura técnica correspondiente exista.

## Qué no entra todavía

- historial de ciclos o cumplimiento;
- estadísticas, rachas, puntajes o recompensas;
- múltiples testigos activos;
- automatización doméstica;
- personalización visual extensa;
- sincronización remota o cuenta en la nube;
- inferencias sobre aburrimiento, pérdida de control o calidad del ocio;
- ejecución completa de los fallos de Bluetooth, batería y segundo plano antes de disponer de integración real.

Excluir estas funciones evita desviar la prueba hacia gestión, vigilancia o personalización. Ninguna es necesaria para examinar si la señal situada devuelve la intención a la decisión.

## Orden de trabajo

### Ahora — congelar wireframe v1

- recorrer los nueve marcos sin explicación del autor;
- corregir textos, continuidad, jerarquía y acciones ambiguas;
- comprobar que la interfaz no promete detectar estados internos;
- registrar cualquier cambio respecto de las exportaciones vigentes;
- fijar esta versión como base del desarrollo antes del 12 de septiembre.

### Siguiente — construir el ciclo base

- implementar la navegación Android del recorrido imprescindible;
- usar una condición local o simulada mientras se define la activación;
- preparar una señal manual segura para el ensayo inicial;
- incorporar los ocho estados críticos de recuperación;
- probar internamente la secuencia completa.

### Después — integrar y ampliar

- comparar el objeto situado con ubicación neutra y notificación;
- decidir la condición y la modalidad de señal mediante evidencia;
- integrar Bluetooth de baja energía solo después de revisar y construir la arquitectura elegida;
- añadir fallos técnicos reales de permisos, batería, conexión y segundo plano;
- incorporar únicamente los estados complementarios que sigan siendo necesarios.

## Criterios para congelar la versión

El wireframe v1 puede considerarse listo para construcción cuando:

- los nueve marcos forman un recorrido continuo;
- cada paso tiene una acción principal y una salida voluntaria comprensibles;
- intención, primer paso, condición, lugar y estado del ciclo se distinguen;
- el testigo se entiende como señal situada y no como segunda pantalla;
- la condición y la señal aparecen como provisionales;
- se pueden recuperar los ocho fallos prioritarios;
- el recorrido no bloquea, puntúa ni registra el cumplimiento;
- cualquier duda restante está asociada a una prueba concreta.

## Pendientes que no deben ocultarse

- Falta realizar el inventario físico y la revisión electrónica competente de B1 y B2.
- No existe todavía una app Android funcional ni una notificación local comparable.
- No se ha construido ni ensayado la señal manual con la ficha técnica.
- No hay resultados con participantes.

Estos pendientes impiden llamar al prototipo producto validado, pero no impiden cerrar el wireframe y comenzar una construcción acotada.

---

## Registro de cambios (disclaimer)

### 2026-09-07 — Creación

- **Qué cambió:** se definieron el recorrido imprescindible, ocho estados críticos, exclusiones, orden de trabajo y criterios de cierre del wireframe v1.
- **Cómo estaba antes:** la documentación cubría nueve marcos y 35 estados, pero no separaba la cobertura total del alcance de la primera construcción.
- **Por qué se decidió:** reducir riesgo, ordenar el desarrollo y mantener cada función vinculada con la pregunta principal del proyecto.
- **Alcance:** planificación de prototipo; no acredita funcionamiento técnico, comprensión, perceptibilidad ni eficacia.
