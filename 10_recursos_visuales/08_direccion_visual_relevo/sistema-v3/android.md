# Sistema visual para Android

## Punto de partida

Los wireframes del Encargo 17 documentan cobertura y estados; no son la arquitectura visual de la aplicación. La interfaz abandona el visor, las fichas explicativas, la descarga y la repetición de una tarjeta gigante. Los 35 estados se traducen en variantes de pocas superficies reutilizables.

## Arquitectura propuesta

| Superficie | Función |
| --- | --- |
| Configurar | Formular intención, primer paso, condición y vigencia. |
| Revisar | Comprobar y editar el ciclo antes de vincularlo. |
| Vincular y probar | Asociar testigo y lugar; comprobar conexión y señal. |
| Esperar | Mostrar ciclo activo y permitir desarmarlo. |
| Cerrar o recuperar | Resolver una decisión personal o un fallo técnico sin confundirlos. |

El pulso ocurre en el espacio físico. La aplicación puede informar que fue entregado, pero no debe simular que el teléfono fue el lugar de la señal.

## Reglas de composición

1. una sola tarea y acción principal por pantalla;
2. contexto breve antes del control, no bloques explicativos laterales;
3. intención y primer paso permanecen reconocibles durante revisión y espera;
4. decisiones personales, contenido y estados técnicos tienen tratamientos distintos;
5. controles familiares de Android para retorno, campos, listas y diálogos;
6. matriz de puntos solo como estado secundario acompañado por texto;
7. sin navegación inferior mientras exista un único recorrido principal;
8. sin métricas, rachas, porcentajes, anillos de progreso o lenguaje moral.

## Fundamento de interacción

La reducción de elecciones simultáneas disminuye carga innecesaria y facilita una decisión principal. Los objetivos de al menos 48 dp responden a las pautas de accesibilidad de Android y son coherentes con la relación entre tamaño, distancia y precisión descrita por Fitts. El reconocimiento se favorece manteniendo visible la intención, el primer paso y el estado del vínculo.

Material 3 se utiliza como infraestructura semántica y de accesibilidad, no como apariencia cerrada. Se conservan componentes y comportamientos conocidos; color, tipografía, ritmo y gramática expresan la identidad de Relevo.

## Claro y oscuro

El modo claro es la configuración cotidiana recomendada. El oscuro conserva las mismas prioridades y controles, ajustando superficies y contraste. El rojo nunca identifica por sí solo conexión, error o decisión. El esquema del sistema puede seguir el tema del dispositivo, pero la persona debe poder cambiarlo.

## Pendientes de prueba

- legibilidad de IBM Plex Sans frente a la fuente del sistema;
- comprensión del motivo de transferencia sin explicarlo previamente;
- diferencia percibida entre decisión personal y fallo técnico;
- escalamiento de texto hasta 200 %;
- lectura con TalkBack y orden de foco;
- funcionamiento con permisos, BLE, batería y segundo plano;
- valor del pulso físico frente a una notificación digital equivalente.

---

## Registro de cambios (disclaimer)

### 2026-08-28 — Creación

- **Cambio:** se reemplazó la lógica visual del visor HTML por cinco superficies reutilizables y reglas específicas de Android.
- **Versión anterior:** cada marco aparecía como una pieza documental y la primera exploración Android mostraba solo tres momentos.
- **Motivo:** conservar el flujo investigado sin trasladar la estructura de una entrega académica al producto.

