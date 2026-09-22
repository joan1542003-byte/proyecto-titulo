# Aplicación Android implementada

**Estado:** dirección vigente de la interfaz funcional.

**Fecha:** 22 de septiembre de 2026.

## Objetivo

La aplicación permite preparar y activar un recordatorio Relevo, observar cuánto tiempo se acumula en una aplicación elegida y recibir una señal cuando se alcanza el límite. La interfaz no intenta retener a la persona: concentra la configuración en una vista, mantiene visible el estado y permite salir, desactivar o silenciar.

## Arquitectura

La pantalla inicial se organiza en tres destinos persistentes:

- **Inicio:** crea un relevo, informa dónde quedó el dispositivo y resume el estado reciente;
- **Actividad:** muestra el tiempo de uso registrado por Android, ordenado por aplicación;
- **Relevos:** conserva un historial breve de ciclos cerrados.

La navegación inferior responde a destinos de igual nivel. `Crear un relevo` permanece como la única acción de mayor énfasis en Inicio. Esta jerarquía evita convertir todas las tarjetas en llamadas a la acción.

Inicio no utiliza saludos ni estados generales como `listo`: presenta directamente el propósito, la acción disponible y datos vinculados al sistema. La explicación ilustrada se reserva para el tutorial, donde imagen, secuencia y texto se leen como una misma instrucción.

## Configuración en una sola vista

La preparación reúne únicamente las decisiones necesarias:

1. actividad que la persona quiere retomar;
2. forma concreta de comenzar;
3. lugar donde se situará la señal;
4. aplicación cuyo uso activa el conteo;
5. tiempo acumulado;
6. consentimiento y permiso de Android.

Tres preestablecidos —caminar, entrenar y leer— completan actividad, comienzo y lugar. Son atajos editables, no categorías cerradas. El tiempo combina valores rápidos con un deslizador de 1 a 60 minutos; la opción de 15 segundos se reserva para comprobar el prototipo.

El selector utiliza el nombre y el icono instalado de cada aplicación. Esto reduce errores de reconocimiento y evita inventar una iconografía paralela para servicios que ya poseen una identidad conocida.

## Estados y retroalimentación

Al activar un relevo, Android mantiene una notificación visible. La vista activa muestra la aplicación seleccionada, el tiempo acumulado y un progreso circular que cambia de forma continua, pero no compite con la información principal.

Cuando se cumple el tiempo:

- se reproduce una alarma breve y vibración;
- aparece una notificación de alta prioridad con la actividad y cómo comenzar;
- la aplicación presenta la señal y permite silenciarla;
- el ciclo puede consultarse después en el historial.

El movimiento se usa para explicar cambios: transición entre vistas, actualización de tarjetas, progreso y pulso de la señal. No se anima texto, iconografía decorativa ni superficies sin cambio de estado. Así se mantiene el principio de un énfasis localizado.

Las transiciones combinan desplazamientos breves y fundidos para conservar continuidad entre origen y destino. Un degradado de variación lenta se limita a la acción principal. Las tarjetas no proyectan sombra: se separan mediante superficie y espacio. La elevación queda reservada para la navegación flotante y la acción principal.

## Decisiones visuales

- **Forma:** radios entre 10 y 30 dp distinguen campos, tarjetas y contenedores sin convertir cada elemento en una cápsula.
- **Color:** el verde Relevo identifica selección, estado activo y acción principal. Las superficies secundarias permanecen neutras.
- **Iconos:** se limitan a acciones y destinos conocidos; nunca reemplazan una etiqueta necesaria. Los iconos de aplicaciones provienen de Android.
- **Profundidad:** cambios de tono, bordes de baja opacidad y superposición distinguen niveles. Las sombras se omiten cuando una superficie ya se diferencia por contraste o posición.
- **Texto:** preguntas y verbos comunes reemplazan términos internos del proyecto.
- **Ilustración:** la introducción muestra la secuencia elegir, situar y recibir la señal. No funciona como control y posee descripción accesible.

## Referentes observados

[Mobbin](https://mobbin.com/) se utilizó para revisar patrones presentes en productos publicados: tableros móviles, navegación inferior, selectores y recorridos de configuración. No se tomó una aplicación como modelo formal; se estudiaron regularidades de jerarquía y comportamiento.

La aplicación utiliza Jetpack Compose como tecnología, pero no adopta Material Design como lenguaje visual. Navegación, superficies, proporciones y transiciones se definen para Relevo. Se conservan convenciones nativas cuando mejoran accesibilidad —áreas táctiles, contraste y respuesta al gesto— sin copiar la apariencia predeterminada del sistema.

La revisión de movimiento consideró las guías de [animación de Jetpack Compose](https://developer.android.com/develop/ui/compose/animation/introduction) y [Motion de Apple](https://developer.apple.com/design/human-interface-guidelines/motion): animar relaciones y cambios, evitar movimiento gratuito y conservar alternativas accesibles. Los Apple Design Awards se observaron como referencia de integración entre interacción, accesibilidad y acabado, no para reproducir una apariencia de iOS.

La revisión de septiembre también consideró recorridos publicados recopilados por [Mobbin](https://mobbin.com/), los [Apple Design Awards 2025](https://developer.apple.com/design/awards/2025/) y la selección [Best of Google Play 2025](https://blog.google/products-and-platforms/platforms/google-play/best-apps-games-2025/). Se extrajeron tres regularidades aplicables: una idea principal por escena, ilustración coherente como apoyo instructivo y continuidad de movimiento entre estados. No se trasladaron composiciones ni identidades de productos específicos.

## Criterios de calidad

La interfaz se considera lista para una prueba funcional cuando:

- una persona puede crear un relevo sin aprender vocabulario propio del proyecto;
- el control seleccionado se distingue de la decoración;
- existe una sola acción dominante por momento;
- los iconos no reemplazan etiquetas necesarias;
- el estado activo y el tiempo restante son comprensibles sin depender del color;
- las notificaciones funcionan con la aplicación fuera de primer plano;
- el historial y las métricas no sugieren éxito conductual que el sistema no puede comprobar.

---

## Registro de cambios (disclaimer)

### 2026-09-22 — Documentación de la interfaz funcional

- **Qué cambió:** se documentaron el tablero, la navegación, los preestablecidos, el selector con iconos reales, el control manual del tiempo, las transiciones y las notificaciones.
- **Cómo era antes:** la especificación describía principios y una secuencia de configuración, pero no registraba la aplicación implementada.
- **Por qué se decidió:** mantener alineadas la documentación visual y la versión que se utilizará en pruebas.
- **Límite:** la calidad de uso debe verificarse con personas; este documento registra decisiones e implementación, no resultados de validación.

### 2026-09-22 — Segunda corrección visual

- **Qué cambió:** se separó tutorial de Inicio, se jerarquizó la selección temporal y se restringieron las estadísticas a aplicaciones vinculadas.
- **Cómo era antes:** la ilustración introductoria ocupaba la portada y Actividad resumía todo el uso informado por Android.
- **Por qué se decidió:** aumentar especificidad, evitar contenido genérico y hacer que cada dato mostrado corresponda al funcionamiento de Relevo.

### 2026-09-22 — Introducción y continuidad espacial

- **Qué cambió:** el aprendizaje inicial se dividió en cinco escenas visibles solo durante el primer inicio; la última explica y solicita los permisos necesarios. La barra inferior pasó a ser un componente propio.
- **Cómo era antes:** una pantalla extensa reunía toda la explicación y la navegación utilizaba un componente visual predeterminado.
- **Por qué se decidió:** disminuir carga de lectura, mantener una idea por pantalla y construir una identidad de interacción consistente sin perder reconocimiento.

### 2026-09-22 — Tutorial visual y consentimiento

- **Qué cambió:** se incorporaron cinco ilustraciones coordinadas que muestran una actividad elegida, la condición de uso, la ubicación del dispositivo, la respuesta a la señal y los permisos necesarios.
- **Cómo era antes:** cada escena dependía de un icono dentro de una superficie vacía.
- **Por qué se decidió:** una instrucción visual debe mostrar la relación entre persona, teléfono, objeto y actividad, no limitarse a decorar el texto.
- **Qué cambió:** el consentimiento utiliza una pantalla propia de alto contraste antes del tutorial; la decisión permanece separada del permiso de acceso de Android.
- **Cómo era antes:** términos y permiso técnico aparecían juntos durante la configuración.
- **Por qué se decidió:** distinguir consentimiento de autorización técnica y asegurar que no se cree una sesión antes de aceptar el uso académico de datos.

### 2026-09-22 — Simplificación de la versión 1.7

- **Qué cambió:** se retiraron rótulos numerados, mayúsculas decorativas y la firma repetida en las pantallas internas. Los botones, opciones y selector de aplicaciones pasaron a utilizar componentes propios de superficie y estado.
- **Cómo era antes:** el tutorial añadía un subtítulo pequeño a cada título y varias vistas repetían la marca sin aportar orientación.
- **Por qué se decidió:** priorizar contenido, lectura y estado sobre ornamentación; la identidad se expresa mediante ritmo, color, tipografía y comportamiento, no mediante repetición del nombre.
- **Qué cambió:** el consentimiento explica el identificador aleatorio con lenguaje cotidiano y la escena final solicita Tiempo de uso y Notificaciones con una razón visible.
- **Cómo era antes:** se usaba el término técnico “código seudónimo” y los permisos aparecían fuera del tutorial.
- **Por qué se decidió:** una persona debe comprender qué acepta y por qué se abre un ajuste del sistema antes de tomar la decisión.
