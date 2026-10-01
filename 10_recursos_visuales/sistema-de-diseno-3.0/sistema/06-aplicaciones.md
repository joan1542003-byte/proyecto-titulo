# Aplicaciones

El mismo sistema en la app, el objeto, la presentación y las piezas de comunicación. En la corrección cruzada se recordó la presentación y no se reconoció en la app; por eso cada pieza repite los mismos tres recursos: el logotipo con su renglón, el azul y la trama.

## App

| Pantalla | Cómo se aplica |
| --- | --- |
| Inicio | Logotipo en la barra; saludo en serif (`displayTitle`); la tarjeta del relevo activo con la foto en trama, `StatusChip`, la firma en `displayCard` y el tiempo en `TimeDots`; pestañas con la elegida llena y sobre el renglón. |
| Preparar | Título en pregunta y en serif; la actividad en `RenglonField`; ideas en `QuickChoice`; `GuardedButton` dice qué falta; el avance en `StepProgress` azul. |
| La señal | Trama que late a pantalla completa; tarjeta de vidrio con el logotipo, «Suena en el parlante» y la firma en `displaySignal`; «Silenciar y continuar» en tinta. |
| Después de la señal | «¿Qué decidiste?» con tres respuestas de un toque en botones secundarios. Sin trama. |
| Ruta, Perfil y ajustes | Listas en `ListSection`; sin trama ni serif salvo el título de la pantalla. |

La app 2.19 llevaría, en este orden: color y tokens; logotipo, ícono de la app y pestañas; campo renglón y firma; tiempo en puntos y pantalla de la señal; titulares en serif; el resto de los íconos.

## Objeto

El parlante lleva una banda en `azul-500` en la base: el renglón puesto en la casa, bajo el lugar donde empieza la actividad. La rejilla del parlante es la trama en el objeto. Etiquetas e instrucciones impresas en dos tintas (`tinta` y `azul-500`), con el logotipo en `relevo-tinta`.

## Presentación

- Fondo blanco o `papel`, Schibsted Grotesk en todo (la presentación deja Inter) y titulares en `displaySlide`.
- Una idea subrayada por diapositiva, con el renglón azul.
- Portada con el logotipo, la trama de campo y el ícono.
- Texto en tercera persona.

## Panel del investigador

Mismos tokens que la app. Las cifras en `mono` y los gráficos en `blue` y `graphite`. Sin trama.

## Comunicación

Afiches y portadas en tres formatos:

1. Campo de trama con una tarjeta de vidrio, el logotipo y una frase en `displayPoster`.
2. Fondo `azul-500` con el logotipo en `blanco` y la trama en `azul-300`.
3. Foto de una actividad en trama con la pregunta en serif y el renglón.

Las palabras de las personas pueden aparecer dispersas en `mono` como textura, solo en estas piezas.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
