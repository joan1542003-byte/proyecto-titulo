# Criterios para la interfaz Android

## Función de la aplicación

La aplicación no es el lugar donde ocurre la señal principal. Su tarea es ayudar a formular una intención, definir un primer paso, preparar una condición, vincular el testigo, comprobar que funciona y recuperar el sistema cuando algo falla.

La nueva interfaz debe partir del contenido y del flujo ya documentados. Android recomienda usar patrones y controles conocidos para reducir aprendizaje, y después incorporar identidad mediante color, tipografía y forma. El sistema operativo también pide respetar preferencias de tema, tamaño de texto y accesibilidad (Android Developers, s. f.-b, s. f.-c).

## Modelo conceptual que debe quedar claro

La persona necesita comprender seis relaciones:

1. la intención y el primer paso pertenecen a la persona;
2. la condición determina cuándo el sistema intenta enviar la orden;
3. el testigo debe estar vinculado y disponible;
4. el lugar es declarado por la persona, no detectado automáticamente;
5. el pulso ocurre en el testigo;
6. cerrar, silenciar, ignorar o rearmar son decisiones distintas.

La interfaz debe mostrar estas relaciones mediante orden, etiquetas y retroalimentación. Un diagrama decorativo no compensa un estado ambiguo.

## Arquitectura visual

### Un propósito principal por pantalla

Las pantallas de configuración deben concentrarse en una decisión: formular, definir el primer paso, elegir condición, revisar, vincular o probar. Los estados técnicos pueden aparecer dentro de la tarea cuando son necesarios; no deben ocupar permanentemente el nivel principal.

### Jerarquía de cuatro capas

1. **Contexto:** título que indica dónde está la persona y qué está haciendo.
2. **Contenido principal:** intención, primer paso, condición o estado del ciclo.
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

El texto debe respetar el escalado configurado por la persona. Los títulos se escriben en estilo oración y las etiquetas deben seguir siendo comprensibles fuera de contexto. Los conceptos propios —intención, primer paso, testigo y ciclo— se mantienen estables.

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

## Primera hipótesis visual para prototipar

Una interfaz de baja ornamentación, basada en superficies neutras, una tipografía principal, componentes Android conocidos y un único acento funcional. La identidad se expresará principalmente mediante la voz, el ritmo de las pantallas y la manera de representar la relación entre intención, primer paso y testigo.

La hipótesis se descarta si produce una aplicación genérica difícil de reconocer, si las personas confunden estados con acciones o si la austeridad obliga a leer explicaciones extensas.

---

## Registro de cambios (disclaimer)

### 2026-09-11 — Creación de criterios Android

- **Qué cambió:** se definieron función, jerarquía, componentes, accesibilidad, lenguaje y una primera hipótesis visual para la aplicación.
- **Cómo era antes:** la estructura del wireframe estaba ligada a una paleta, tipografía y modo visual de una etapa anterior.
- **Por qué se decidió:** conservar el aprendizaje funcional del flujo sin convertir su acabado previo en autoridad.
- **Límite:** este documento no diseña pantallas ni fija tokens; las decisiones visuales se cerrarán después de comparar prototipos.
