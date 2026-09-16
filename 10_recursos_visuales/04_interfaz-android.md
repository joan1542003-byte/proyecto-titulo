# Criterios para la interfaz Android

**Actualización del 15 de septiembre de 2026:** estos criterios siguen vigentes. Su primera traducción formal se encuentra en la [dirección visual](10_direccion-visual-provisional.md), el [sistema cromático y tipográfico](11_sistema-cromatico-y-tipografico-provisional.md) y la [especificación de interfaz](12_especificacion-ui-provisional.md).

## Función de la aplicación

La aplicación no es el lugar donde ocurre la señal principal. Su tarea es ayudar a formular una intención, aclarar cómo podría comenzar, preparar una condición, vincular el testigo, comprobar que funciona y recuperar el sistema cuando algo falla.

La nueva interfaz debe partir del contenido y del flujo ya documentados. Android recomienda usar patrones y controles conocidos para reducir aprendizaje, y después incorporar identidad mediante color, tipografía y forma. El sistema operativo también pide respetar preferencias de tema, tamaño de texto y accesibilidad (Android Developers, s. f.-b, s. f.-c).

## Modelo conceptual que debe quedar claro

La persona necesita comprender seis relaciones:

1. la intención y la forma de comenzar pertenecen a la persona;
2. la condición determina cuándo el sistema intenta enviar la orden;
3. el testigo debe estar vinculado y disponible;
4. el lugar es declarado por la persona, no detectado automáticamente;
5. el pulso ocurre en el testigo;
6. cerrar, silenciar, ignorar o rearmar son decisiones distintas.

La interfaz debe mostrar estas relaciones mediante orden, etiquetas y retroalimentación. Un diagrama decorativo no compensa un estado ambiguo.

## Arquitectura visual

### Un propósito principal por pantalla

Las pantallas de configuración deben concentrarse en una decisión: formular, aclarar cómo comenzar, elegir condición, revisar, vincular o probar. Los estados técnicos pueden aparecer dentro de la tarea cuando son necesarios; no deben ocupar permanentemente el nivel principal.

### Jerarquía de cuatro capas

1. **Contexto:** título que indica dónde está la persona y qué está haciendo.
2. **Contenido principal:** actividad, forma de comenzar, condición o estado del ciclo.
3. **Apoyo:** explicación breve, consecuencia o instrucción de recuperación.
4. **Acciones:** una acción principal y las salidas secundarias pertinentes.

No es necesario encerrar cada capa en una tarjeta. El espacio, la alineación y la tipografía pueden agrupar antes de añadir contenedores.

### Densidad controlada

La simplicidad de una interfaz no depende solo de tener pocos elementos. También depende de la organización, la complejidad de la tarea y la coordinación entre componentes (Choi & Lee, 2012). Relevo no debe esconder decisiones esenciales para parecer mínimo. Debe mostrar lo necesario en el momento adecuado y retirar información que no afecta la acción presente.

## Componentes y estados

| Elemento | Tratamiento recomendado | Evitar |
| --- | --- | --- |
| Campos de texto | Etiqueta visible, ayuda concreta y estado de error recuperable | Depender del texto de ejemplo como etiqueta. |
| Selecciones | Grupo con pregunta explícita y opciones textuales | Cápsulas decorativas cuyo estado depende solo del color. |
| Acción principal | Verbo que describe el resultado: `Revisar`, `Vincular`, `Probar`, `Armar` | `Continuar` cuando la consecuencia no es evidente. |
| Acción destructiva | Texto específico y confirmación proporcional | Ocultarla hasta volverla imposible de encontrar. |
| Estado técnico | Descripción + consecuencia + acción posible | Luces abstractas o términos como `offline` sin explicación. |
| Estado del ciclo | Nombre estable y resumen del contenido relevante | Progreso porcentual, racha o puntaje. |
| Icono | Apoyo a una etiqueta o control conocido | Reemplazar conceptos propios de Relevo con símbolos no probados. |
| Decoración | Presencia escasa y fuera de objetivos táctiles | Elementos que parezcan botones o indicadores. |

## Color y temas

La paleta debe organizarse por roles: fondo, superficie, texto principal, texto secundario, acción, selección, estado informativo, advertencia y error. Android recomienda no mezclar demasiados colores semánticos, mantener significados consistentes y no usar el color como única señal (Android Developers, s. f.-d).

Relevo debe contemplar tema claro y oscuro porque el sistema se usará en contextos e iluminaciones variables y porque Android recomienda seguir la preferencia de la persona. Ninguno será la identidad exclusiva. Primero se definirá una base neutra y luego un acento de baja extensión para acciones o estados que realmente necesiten énfasis.

No se fija todavía un color de marca definitivo. El color de la luz física tampoco tiene que ser idéntico al acento digital: uno es un estímulo situado y el otro organiza una interfaz. Su relación debe ser semántica y comprobable, no una coincidencia literal.

## Tipografía

La primera alternativa debe usar una familia compatible con Android, con buena lectura en español y suficientes pesos. Una sola familia reduce carga de producción y evita que la diferenciación dependa de contrastes tipográficos innecesarios. La identidad puede construirse mediante proporción, espaciado y tono antes de introducir una segunda familia.

El texto debe respetar el escalado configurado por la persona. Los títulos se escriben en estilo oración y las etiquetas deben seguir siendo comprensibles fuera de contexto. `Primer paso` permanece como concepto analítico; la interfaz pregunta `¿Cómo podrías empezar?` y muestra `Cómo empezar`. Los términos `testigo`, `ciclo` y `armar` también deben comprobarse antes de tratarlos como lenguaje público definitivo.

## Accesibilidad mínima

- Contraste de texto normal de al menos 4,5:1 y de componentes esenciales de al menos 3:1, según WCAG 2.2.
- Áreas táctiles mínimas de 48 × 48 dp.
- Etiquetas accesibles únicas para controles gráficos.
- Orden de foco coherente con la lectura visual.
- Funcionamiento con TalkBack y tamaño de texto aumentado.
- Estados distinguibles sin color.
- Acciones reversibles y mensajes que indiquen cómo recuperarse.
- Movimiento no indispensable y posibilidad de reducirlo.

Los validadores automáticos detectan problemas básicos, pero no pueden determinar si una etiqueta se entiende o si el recorrido principal es coherente. Android recomienda combinar herramientas con pruebas manuales y con personas (Android Developers, s. f.-a).

## Lenguaje de interfaz

El W3C recomienda palabras comunes, frases breves, bloques acotados e instrucciones separadas cuando una tarea exige varios pasos (W3C, 2021). En Relevo esto implica:

- escribir desde la acción disponible;
- explicar términos la primera vez;
- evitar metáforas en errores y permisos;
- no usar frases que elogien o reprendan;
- indicar qué ocurrió y qué puede hacerse después;
- no repetir el mismo mensaje en título, cuerpo y botón.

Ejemplo de estado técnico:

**El testigo perdió la conexión.** Acércalo al teléfono y vuelve a intentar. Tu ciclo sigue guardado.

Este texto separa hecho, recuperación y efecto sobre el contenido sin culpar a la persona.

## Dirección visual vigente

La interfaz utiliza baja ornamentación, superficies neutras, Source Sans 3, componentes Android conocidos y un único acento verde turquesa asignado a acciones o estados específicos. La identidad también se expresa en la voz, el ritmo de las pantallas y la relación entre actividad, forma de comenzar y dispositivo. Los valores pertenecen al sistema vigente; su adopción no equivale a una validación de uso.

La dirección se corrige si produce una aplicación genérica difícil de reconocer, si las personas confunden estados con acciones o si la austeridad obliga a leer explicaciones extensas.

---

## Registro de cambios (disclaimer)

### 2026-09-16 — Dirección de interfaz adoptada

- **Qué cambió:** superficies neutras, Source Sans 3, patrones Android y acento localizado pasan a ser la base vigente de interfaz.
- **Cómo era antes:** se describían como una primera hipótesis visual para comparar.
- **Por qué se decidió:** construir pantallas coherentes y reservar la iteración para problemas observables de uso.
- **Límite:** la adopción no acredita comprensión ni desempeño.

### 2026-09-15 — Variante de interfaz separada de la marca

- **Qué cambió:** el turquesa dejó de recibir un significado narrativo y se limita a funciones observables dentro del prototipo.
- **Cómo era antes:** se presentaba como `color de presencia` y como vínculo directo con el relato de marca.
- **Por qué se decidió:** una interfaz es un punto de contacto del producto, no la totalidad de su marca.
- **Límite:** los valores siguen disponibles para pruebas de uso y contraste; no cierran la identidad.

### 2026-09-15 — Lenguaje de tarea y color de presencia

- **Qué cambió:** se retiró `primer paso` como etiqueta autónoma de interfaz, se incorporó `¿Cómo podrías empezar?` y el turquesa se vinculó al relato de presencia.
- **Cómo era antes:** el documento pedía mantener `primer paso` como término estable y describía el acento solo por su función digital.
- **Por qué se decidió:** la interfaz debe utilizar palabras reconocibles y conectar la marca con una conducta observable sin convertirla en ornamentación.
- **Límite:** los textos y las asociaciones cromáticas siguen pendientes de prueba.

### 2026-09-15 — Traducción de criterios a una hipótesis formal

- **Qué cambió:** se enlazaron las especificaciones nuevas y se precisaron la familia tipográfica y el acento de la primera variante.
- **Cómo era antes:** el documento recomendaba una familia y un acento, pero los mantenía sin valores concretos.
- **Por qué se decidió:** evitar que la guía de interfaz contradiga el estado actual del sistema visual.
- **Límite:** la selección todavía debe superar pruebas de uso, accesibilidad y reconocimiento.

### 2026-09-11 — Creación de criterios Android

- **Qué cambió:** se definieron función, jerarquía, componentes, accesibilidad, lenguaje y una primera hipótesis visual para la aplicación.
- **Cómo era antes:** la estructura del wireframe estaba ligada a una paleta, tipografía y modo visual de una etapa anterior.
- **Por qué se decidió:** conservar el aprendizaje funcional del flujo sin convertir su acabado previo en autoridad.
- **Límite:** este documento no diseña pantallas ni fija tokens; las decisiones visuales se cerrarán después de comparar prototipos.
