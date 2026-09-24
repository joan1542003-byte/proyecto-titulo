# Movimiento y personalización en Relevo Android

**Revisión documental histórica:** 22 de septiembre de 2026. **Alcance:** versión Android 2.0 y referentes web; no incluye pruebas nuevas con personas ni cambios de implementación. Para decisiones implementadas en 2.6, consultar [Diseño y experiencia](DISENO-Y-EXPERIENCIA.md) y [revisión del feedback](revision-feedback-2026-09-23.md). Las menciones a una sola app o al parlante como única salida describen esa versión anterior, no el estado actual.

## Lo que muestran los referentes

[Amicro](https://github.com/Subhan-code/Amicro--Micro-transitions-) reúne microinteracciones, transiciones de entrada y composiciones de tarjetas para React. Su catálogo distingue, por ejemplo, aparición, desplazamiento y ampliación, además de tarjetas con abanicos, carruseles y respuestas al cursor. La idea transferible es que un cambio visual breve puede hacer reconocible una acción o un estado. Sus componentes TSX, `motion/react`, Tailwind, efectos *hover* y disposiciones espaciales son recursos de web: no son componentes Android ni justifican llevar sus gestos o sus tiempos a Relevo.

El enlace [t.co/bMVmwqtIvx](https://t.co/bMVmwqtIvx) redirigió, en esta revisión, a [sean-brydon/devl.dev](https://github.com/sean-brydon/devl.dev). Su autor lo describe como un cuaderno de experimentos de interfaz, no como un producto terminado. Son útiles dos patrones concretos: [onboarding](https://www.devl.dev/c/auth/onboarding) distribuye la preparación en decisiones comprensibles y [preferencias de notificación](https://www.devl.dev/c/forms/notifications) parte de opciones discretas y explica qué se avisa. La [barra inferior de muestra](https://www.devl.dev/c/layouts/bottom-nav) demuestra una estructura de navegación, pero su contenido social, sus cinco destinos y su estética no corresponden al ciclo de Relevo. Tampoco se trasladan coss-ui, Base UI, Tailwind ni el código React.

Estos son referentes de diseño, no evidencia de que una animación aumente la comprensión o de que una configuración reduzca molestias en Relevo.

## Decisiones para el recorrido Android

La versión 2.0 ya usa `AnimatedContent` para cambiar pantallas y pestañas, progreso animado durante la espera, un degradado lento en la acción principal y un pulso gráfico en la señal. El movimiento debe explicar **qué cambió**, con el menor énfasis posible:

| Momento | Decisión de diseño | Límite |
| --- | --- | --- |
| Inicio → preparación | Mantener una transición breve que preserve la orientación; la actividad elegida debe quedar escrita y editable. | No encadenar entradas de tarjetas ni retrasar la primera acción. |
| Configurar → activar | Mostrar de inmediato app elegida, tiempo y lugar; animar solo la confirmación de estado. | La transición no puede parecer una activación antes de confirmarla. |
| Espera → señal | Priorizar actividad, «cómo empezar» y silencio visible; el pulso gráfico puede acompañar el cambio. | La animación no sustituye la notificación, el texto ni el control de silencio. |
| Silenciar, desactivar o cerrar | Hacer visible el estado final sin celebración ni castigo. | No inferir que se realizó la actividad. |

Personalización significa aquí configurar una **intención concreta**: actividad propia o sugerida, cómo comenzar, aplicación observada, tiempo y lugar declarado. Las siete imágenes actuales son accesos opcionales, no perfiles ni predicciones. Para la señal, conservar la prueba breve del parlante y el silencio inmediato; explorar intensidad, canal u horarios tranquilos solo si un ensayo revela necesidad y existe control técnico verificable. Una preferencia nunca debe ocultar si el parlante Bluetooth está disponible ni prometer que sonará cuando la salida no está confirmada. No añadir rachas, recompensas, temas extensos ni ajustes por cada microanimación: desplazarían la tarea central y pueden convertir el aviso en presión.

## Accesibilidad y antipatrones

Android ofrece `AnimatedContent`, `AnimatedVisibility` y animación de propiedades para cambios de estado; su [guía de Compose](https://developer.android.com/develop/ui/compose/animation/quick-guide) advierte que ocultar solo mediante transparencia puede dejar un elemento presente para lectores de pantalla. Por eso una opción que deja de existir debe salir también de la estructura accesible. Los estados esenciales deben tener texto y semántica, con foco y orden de lectura coherentes; los gráficos concéntricos son decorativos. La [guía de semántica](https://developer.android.com/develop/ui/compose/accessibility/semantics) y los [valores accesibles predeterminados](https://developer.android.com/develop/ui/compose/accessibility/api-defaults) de Android orientan esta revisión, incluidos objetivos táctiles de al menos 48 dp.

La interfaz declara omitir transiciones cuando Android desactiva animaciones. En el código revisado, esa preferencia se lee una vez con `remember` desde `ANIMATOR_DURATION_SCALE`; las transiciones principales tienen una variante sin movimiento, mientras el degradado y el pulso fijan un destino estático cuando la lectura inicial es cero. Es una **observación de código**, no una comprobación de comportamiento en dispositivo: falta verificar cambios del ajuste durante una sesión, y revisar que el progreso y cualquier otra animación respeten la preferencia. [Android documenta](https://developer.android.com/reference/android/provider/Settings.Global#ANIMATOR_DURATION_SCALE) el valor cero como finalización inmediata de las animaciones basadas en `Animator`; no basta con presumir que cubre por igual cada efecto Compose personalizado.

Evitar: movimiento perpetuo en controles secundarios; señal visual que exija mirar el teléfono; deslizamientos que desplacen botones mientras se intenta tocarlos; significado comunicado solo por color, sonido o animación; opciones de personalización que aumenten el aviso sin permitir probarlo y silenciarlo. El pulso físico previsto y el sonido Bluetooth de este prototipo tampoco deben confundirse: la app todavía no acredita el dispositivo final con luz y sonido.

## Plan de prueba pendiente

1. En teléfono y parlante concretos, recorrer preparación, activación, espera, señal y cierre con animaciones normales y desactivadas; repetir el cambio de ajuste con Relevo abierto. Registrar si el estado y el botón de silencio siguen disponibles sin demora.
2. Con TalkBack, recorrer pestañas, actividad sugerida y propia, selector de tiempo, aviso y silencio. Comprobar nombres, orden, foco después de cada transición y ausencia de elementos invisibles anunciados. Repetir con texto ampliado, pantalla pequeña y contraste revisado.
3. Comparar, en una prueba de comprensión, la transición actual con una variante estática. Preguntar qué quedó activo, por qué llegó la señal y cómo detenerla; registrar confusiones y tiempos, sin declarar una versión superior antes de obtener resultados.
4. Probar la personalización mínima: actividad sugerida frente a propia, edición de «cómo empezar», tiempo y lugar; observar si las opciones ayudan a preparar el relevo o añaden decisiones innecesarias. Registrar por separado disponibilidad de audio, percepción de la señal e intrusión.

Los [controles de accesibilidad de Compose](https://developer.android.com/develop/ui/compose/accessibility/testing) pueden detectar algunos problemas de contraste, tamaño táctil y recorrido, pero no reemplazan la prueba manual. Ninguna de las pruebas de esta sección se realizó para este documento. La revisión en emulador y las pruebas unitarias de la versión 2.0 constan en la documentación de la app; no validan estas decisiones de movimiento o personalización con usuarios.

## Registro de cambios (disclaimer)

### 2026-09-24 — Aclaración de vigencia

- **Cambio:** se marca este análisis como antecedente de Android 2.0 y se enlazan las decisiones 2.6.
- **Antes:** podía leerse como especificación actual pese a los cambios posteriores.
- **Motivo:** conservar el razonamiento sin confundirlo con el funcionamiento vigente.

### 2026-09-22 — Creación

- **Cambio:** se compararon dos referentes web con el flujo Android vigente y se fijaron criterios de movimiento, personalización y prueba.
- **Antes:** no existía una auditoría específica de este tema en `app-android`.
- **Motivo:** distinguir patrones transferibles de componentes React y mantener visibles las verificaciones pendientes.
- **Alcance:** solo documentación; no se modificaron código, binarios ni otros documentos.
