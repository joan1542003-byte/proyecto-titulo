export type Mode = "entrega" | "cobertura";

export type VisualKind =
  | "empty"
  | "form"
  | "review"
  | "search"
  | "device"
  | "test"
  | "ready"
  | "arming"
  | "active"
  | "decision"
  | "closed"
  | "error"
  | "physical";

export type Wireframe = {
  id: string;
  coverageState: string;
  interaction: string;
  title: string;
  short: string;
  slug: string;
  objective: string;
  critical: string;
  action: string;
  hierarchy: string;
  error: string;
  legend: string;
  visual: VisualKind;
  eyebrow?: string;
};

export type CoverageState = Wireframe & {
  family: string;
  familyShort: string;
  trigger: string;
  continuity: string;
  primary: string;
  secondary: string[];
};

export const deliveryFrames: Wireframe[] = [
  {
    id: "1.1",
    coverageState: "01",
    interaction: "1 · Formular y preparar una intención",
    title: "Formular",
    short: "Registrar la intención y su primer paso.",
    slug: "1-1-formular",
    objective: "Hacer explícita una actividad que la persona desea mantener disponible.",
    critical: "Intención personal y primer paso concreto.",
    action: "Crear intención y continuar con la configuración.",
    hierarchy: "Título → propósito → campos → acción primaria.",
    error: "Si no hay intención o primer paso, se mantiene como borrador y se puede completar después.",
    legend: "La persona formula qué desea mantener disponible.\nEl primer paso reduce la distancia entre recordar y comenzar.\nLa pantalla no interpreta el motivo ni califica la actividad.\nLa salida conecta con la condición provisional.",
    visual: "form",
  },
  {
    id: "1.2",
    coverageState: "02",
    interaction: "1 · Formular y preparar una intención",
    title: "Configurar condición provisional",
    short: "Elegir una condición observable y una vigencia.",
    slug: "1-2-configurar-condicion",
    objective: "Explicar qué evento técnico podría activar el pulso, sin presentarlo como una validación.",
    critical: "Condición provisional, aplicación elegida y ventana de vigencia.",
    action: "Seleccionar una alternativa comprensible y revisar el ciclo.",
    hierarchy: "Título → resumen → selector → vigencia → acción.",
    error: "Si falta un dato, se marca como incompleto; un permiso requerido se comunica aparte como estado técnico.",
    legend: "La condición se entiende como una hipótesis estructural.\nLa persona puede elegirla, modificarla o dejar el ciclo en borrador.\nLa interfaz no afirma detectar aburrimiento, culpa ni pérdida de control.\nLa salida conduce a una revisión antes de asociar el testigo.",
    visual: "form",
  },
  {
    id: "1.3",
    coverageState: "05",
    interaction: "1 · Formular y preparar una intención",
    title: "Revisar",
    short: "Comprobar los datos mínimos antes de situar.",
    slug: "1-3-revisar",
    objective: "Reunir la intención, el primer paso, la condición y la vigencia en una lectura breve.",
    critical: "Qué se hará, cómo empieza, qué condición se observará y hasta cuándo.",
    action: "Editar o continuar para vincular y situar el testigo.",
    hierarchy: "Título → cuatro tarjetas de resumen → estado → acciones.",
    error: "Un permiso pendiente o una condición incompleta impide continuar sin borrar el borrador.",
    legend: "La revisión reúne el contenido mínimo del ciclo.\nLa jerarquía prioriza la intención y el primer paso antes que la técnica.\nEl estado recuerda que la condición sigue por validar.\nLa salida conecta con la vinculación manual del testigo.",
    visual: "review",
  },
  {
    id: "2.1",
    coverageState: "08",
    interaction: "2 · Situar, probar y armar el testigo",
    title: "Situar",
    short: "Vincular el testigo y relacionarlo con el primer paso.",
    slug: "2-1-situar",
    objective: "Hacer explícita la asociación entre objeto, intención y lugar elegido.",
    critical: "Testigo identificado, vínculo disponible y lugar declarado manualmente.",
    action: "Vincular el testigo y continuar a la prueba situada.",
    hierarchy: "Título → escena física → estado de vínculo → acción.",
    error: "Un testigo no reconocido o sin batería vuelve a búsqueda o carga; no se presenta como error de la persona.",
    legend: "La intención deja de ser solo información digital y se relaciona con un lugar.\nEl objeto no contiene pantalla ni consulta; su presencia es contextual.\nLa vinculación y la ubicación son acciones manuales y reversibles.\nLa salida lleva a probar el pulso junto al primer paso.",
    visual: "device",
  },
  {
    id: "2.2",
    coverageState: "11",
    interaction: "2 · Situar, probar y armar el testigo",
    title: "Probar el pulso",
    short: "Emitir una señal para revisar percepción y convivencia.",
    slug: "2-2-probar-pulso",
    objective: "Comprobar si la señal situada es reconocible y puede detenerse.",
    critical: "Relación con el primer paso, resultado declarado por la persona y control de ajuste.",
    action: "Emitir el pulso de prueba y declarar si se percibe, interfiere o requiere ajuste.",
    hierarchy: "Título → escena → tarjetas de contexto → control físico → acciones.",
    error: "La señal no percibida o intrusiva vuelve a ajuste de señal o lugar; no afirma una percepción automática.",
    legend: "La prueba observa la relación entre señal, superficie y convivencia.\nLa percepción es declarada por la persona, no inferida por el sistema.\nAjustar o reubicar son salidas tan legítimas como continuar.\nLa prueba antecede al armado explícito.",
    visual: "test",
  },
  {
    id: "2.3",
    coverageState: "14",
    interaction: "2 · Situar, probar y armar el testigo",
    title: "Armar mediante control físico",
    short: "Confirmar el armado con una pulsación prolongada.",
    slug: "2-3-armar-control-fisico",
    objective: "Cerrar la preparación con una acción explícita que deja el ciclo listo para esperar.",
    critical: "Intención, primer paso, condición provisional, vigencia y testigo situado.",
    action: "Mantener presionado el control físico provisional para armar.",
    hierarchy: "Título → resumen del ciclo → control físico → salida voluntaria.",
    error: "Si el vínculo no confirma el armado, se puede reintentar, revisar el enlace o salir sin armar.",
    legend: "El armado requiere una acción deliberada y visible.\nLa pulsación prolongada es un control provisional, no una especificación cerrada.\nLa pantalla informa el estado sin instalar una interfaz en el objeto.\nLa salida conecta con la espera o permite no continuar.",
    visual: "ready",
  },
  {
    id: "3.1",
    coverageState: "20",
    interaction: "3 · Recibir el pulso y cerrar el ciclo",
    title: "Esperar",
    short: "Mostrar el ciclo armado y la condición vigente.",
    slug: "3-1-esperar",
    objective: "Hacer legible que el ciclo está activo sin juzgar la actividad digital.",
    critical: "Intención, primer paso, condición en espera, vigencia y testigo situado.",
    action: "Dejar el teléfono, consultar el estado o desarmar explícitamente.",
    hierarchy: "Título → estado armado → resumen → nota de vigencia → acción.",
    error: "Permiso revocado, segundo plano restringido o pérdida de vínculo se muestran como recuperaciones técnicas.",
    legend: "La espera deja a la persona fuera de una lectura moral de su actividad.\nLa condición se muestra como observable y provisional.\nEl testigo situado sostiene la relación con el primer paso.\nEl ciclo puede desarmarse sin sanción ni rearme automático.",
    visual: "arming",
  },
  {
    id: "3.2",
    coverageState: "23",
    interaction: "3 · Recibir el pulso y cerrar el ciclo",
    title: "Recibir el pulso situado",
    short: "Representar el momento físico en el lugar elegido.",
    slug: "3-2-recibir-pulso-situado",
    objective: "Hacer visible el contexto phygital sin convertir el testigo en una pantalla.",
    critical: "Testigo sin interfaz, primer paso cercano y pulso ambiental único.",
    action: "Percibir y decidir libremente: iniciar, continuar, ignorar o silenciar.",
    hierarchy: "Escena física → relación con el primer paso → respuestas válidas.",
    error: "Si no hay entrega confirmable, la recuperación ocurre en la aplicación y puede cerrar sin emitir un pulso tardío.",
    legend: "El momento ocurre en el espacio y no dentro de una interfaz instalada en el objeto.\nEl testigo solo emite un pulso ambiental situado.\nLa persona puede actuar, continuar, ignorar o silenciar.\nNinguna respuesta se registra como cumplimiento.",
    visual: "physical",
  },
  {
    id: "3.3",
    coverageState: "25",
    interaction: "3 · Recibir el pulso y cerrar el ciclo",
    title: "Cerrar o recuperar",
    short: "Terminar el ciclo o volver desde un fallo técnico.",
    slug: "3-3-cerrar-o-recuperar",
    objective: "Ofrecer un cierre explícito y una recuperación técnica comprensible en el mismo marco.",
    critical: "Ciclo terminado, decisión libre posterior y variante de estado técnico.",
    action: "Cerrar, preparar otro ciclo, revisar el vínculo o reintentar.",
    hierarchy: "Título → estado de cierre → acciones agrupadas → variante recuperable.",
    error: "BLE, batería, permiso o vencimiento se tratan como estados técnicos recuperables, nunca como incumplimiento.",
    legend: "El ciclo termina después del pulso, silencio o vencimiento.\nLa persona no tiene que demostrar que inició la actividad.\nLa recuperación técnica permanece en el mismo marco y no agrega una cuarta pantalla.\nRearmar siempre exige revisar y confirmar de nuevo.",
    visual: "closed",
  },
];

const familyInfo = {
  "A · Configuración": "A",
  "B · Vinculación y prueba física": "B",
  "C · Armado": "C",
  "D · Espera y señal": "D",
  "E · Cierre y recuperación": "E",
} as const;

const coverageRows: Array<[
  string,
  string,
  string,
  string,
  string,
  string,
  string,
  VisualKind,
  string,
  string[],
  string,
]> = [
  ["01", "Sin configurar", "No existe un ciclo activo.", "Crear una intención.", "02", "Hacer visible el punto de partida del ciclo.", "No hay intención ni primer paso que mostrar.", "empty", "Crear intención", ["Permanecer inactivo"], "A · Configuración"],
  ["02", "Datos incompletos", "Falta intención, primer paso, condición o vigencia.", "Completar o corregir.", "03 o 05", "Reunir los datos mínimos sin forzar continuidad.", "El dato faltante queda marcado como incompleto.", "form", "Completar datos", ["Guardar borrador", "Volver"], "A · Configuración"],
  ["03", "Permiso requerido", "La condición necesita un permiso de Android.", "Revisar y solicitar permiso.", "04 o 05", "Explicar por qué existe una dependencia técnica.", "El permiso aún no está concedido.", "error", "Revisar permiso", ["Cambiar condición", "Volver"], "A · Configuración"],
  ["04", "Permiso denegado", "Android no concede el permiso solicitado.", "Abrir ajustes o cambiar condición.", "03, 02 o 06", "Mantener una salida sin borrar la intención.", "La condición elegida no puede observarse ahora.", "error", "Abrir ajustes", ["Cambiar condición", "Salir"], "A · Configuración"],
  ["05", "Revisión", "Los datos mínimos están completos.", "Confirmar preparación o editar.", "07 o 02", "Comprobar el ciclo antes de asociar el objeto.", "La condición sigue por validar.", "review", "Continuar para situar", ["Editar", "Guardar borrador"], "A · Configuración"],
  ["06", "Salida voluntaria", "La persona decide no continuar.", "Descartar borrador o volver.", "01 o 05", "Respetar la decisión de pausar la preparación.", "La salida no se interpreta como error.", "closed", "Guardar borrador", ["Descartar borrador", "Seguir editando"], "A · Configuración"],
  ["07", "Buscando testigo", "Comienza la asociación física.", "Esperar, reintentar o cancelar.", "08, 09 o 06", "Hacer visible que la búsqueda está en curso.", "No hay testigo confirmado todavía.", "search", "Buscar de nuevo", ["Cancelar", "Esperar"], "B · Vinculación y prueba física"],
  ["08", "Elegir y confirmar testigo", "Se encuentra uno o más dispositivos.", "Identificar y vincular el correcto.", "10 u 11", "Confirmar identidad, vínculo y batería antes de situar.", "Elegir otro testigo si no coincide.", "device", "Vincular testigo", ["Elegir otro"], "B · Vinculación y prueba física"],
  ["09", "Testigo no reconocido", "El dispositivo no coincide o no responde.", "Volver a buscar.", "07", "Comunicar el fallo sin responsabilizar a la persona.", "Vínculo no disponible; el objeto no fue confirmado.", "error", "Buscar de nuevo", ["Cancelar"], "B · Vinculación y prueba física"],
  ["10", "Batería baja", "El testigo vinculado no asegura el ciclo.", "Cargarlo o posponer.", "11 o 06", "Hacer visible una limitación técnica antes de probar.", "La carga es insuficiente para continuar.", "error", "Cargar testigo", ["Posponer"], "B · Vinculación y prueba física"],
  ["11", "Probar lugar", "El testigo se ubica junto al primer paso.", "Emitir pulso de prueba.", "12, 13 o 14", "Comprobar relación entre lugar, señal y acción próxima.", "El lugar es declarado manualmente.", "test", "Emitir pulso", ["Ajustar lugar"], "B · Vinculación y prueba física"],
  ["12", "Señal no percibida", "La persona no detecta el pulso de prueba.", "Ajustar señal o reubicar.", "11", "Dejar que la persona declare el resultado.", "No se afirma que el sistema pueda medir percepción.", "error", "Probar de nuevo", ["Ajustar señal", "Cambiar lugar"], "B · Vinculación y prueba física"],
  ["13", "Señal intrusiva", "El pulso se percibe, pero interfiere con el contexto.", "Reducir, reubicar o volver a probar.", "11", "Equilibrar discreción, percepción y convivencia.", "La intrusión es una respuesta declarada, no una métrica cerrada.", "error", "Ajustar señal", ["Cambiar lugar", "No armar"], "B · Vinculación y prueba física"],
  ["14", "Listo para armar", "Lugar, vínculo y pulso fueron comprobados.", "Iniciar armado explícito.", "15", "Mostrar el ciclo preparado sin adelantar el armado.", "La condición y el canal siguen siendo provisionales.", "ready", "Continuar al armado", ["Volver a probar", "Salir sin armar"], "B · Vinculación y prueba física"],
  ["15", "Vinculando o armando", "Se solicita el armado.", "Esperar confirmación o cancelar.", "16 o 17", "Informar la transición al estado armado.", "La confirmación puede no llegar.", "arming", "Esperar confirmación", ["Cancelar"], "C · Armado"],
  ["16", "Armado", "Android y testigo confirman el ciclo activo.", "Dejar el teléfono o desarmar.", "20 o 18", "Hacer legible que la condición está vigente.", "Desarmar termina el ciclo sin sanción.", "arming", "Desarmar", ["Dejar el teléfono"], "C · Armado"],
  ["17", "Confirmación ambigua o fallo", "No existe confirmación suficiente del armado.", "Reintentar, revisar enlace o cancelar.", "15, 29 o 18", "Separar el fallo técnico de la decisión personal.", "El estado del vínculo no está confirmado.", "error", "Reintentar", ["Revisar enlace", "Desarmar"], "C · Armado"],
  ["18", "Desarmado voluntario", "La persona detiene el ciclo.", "Cerrar o volver a preparar.", "01, 05 o 34", "Permitir detener el ciclo sin juicio.", "No se emitirá ningún pulso después del desarmado.", "closed", "Preparar de nuevo", ["Cerrar ciclo"], "C · Armado"],
  ["19", "Editar mientras está armado", "Se intenta cambiar un ciclo activo.", "Desarmar antes de editar o conservarlo.", "18, 02 o 20", "Evitar cambios ambiguos durante la vigencia.", "El ciclo debe desarmarse antes de cambiar datos.", "error", "Desarmar y editar", ["Conservar ciclo"], "C · Armado"],
  ["20", "Armado en espera", "El ciclo está activo y la condición aún no ocurre.", "Consultar estado o desarmar.", "21, 18 o 33", "Representar espera sin interpretar la actividad digital.", "La condición solo se observa si sigue vigente.", "arming", "Desarmar", ["Consultar estado"], "D · Espera y señal"],
  ["21", "Condición cumplida y orden válida", "Android reconoce la condición dentro de la vigencia.", "Enviar la orden al testigo.", "23 o 29", "Mostrar una orden técnica en tránsito.", "La entrega puede perderse o quedar sin confirmar.", "active", "Enviar al testigo", ["Desarmar"], "D · Espera y señal"],
  ["22", "Orden tardía o expirada", "La orden llega fuera de la vigencia.", "Cerrar sin pulso o preparar otro ciclo.", "33 o 34", "Evitar una señal fuera de contexto.", "No se emitirá un pulso tardío.", "error", "Cerrar ciclo", ["Preparar de nuevo"], "D · Espera y señal"],
  ["23", "Señal física activa", "El testigo emite el único pulso situado.", "Percibir y decidir libremente.", "24 o 25", "Representar el momento situado sin pantalla en el objeto.", "La entrega no se convierte en una orden ni registra conducta.", "physical", "Percibir el pulso", ["Continuar", "Silenciar"], "D · Espera y señal"],
  ["24", "Silenciar, ignorar o continuar", "La persona responde al pulso sin obligación.", "Silenciar y cerrar; actuar queda fuera del registro.", "25", "Hacer equivalentes las respuestas posteriores.", "Ninguna respuesta se registra como cumplimiento.", "decision", "Silenciar", ["Continuar", "Iniciar primer paso"], "D · Espera y señal"],
  ["25", "Intención cumplida o cierre", "La persona decide terminar el ciclo.", "Cerrar sin registrar cumplimiento.", "01 o 34", "Cerrar el ciclo sin exigir evidencia de acción.", "El cierre no afirma que la intención se realizó.", "closed", "Cerrar ciclo", ["Preparar otro ciclo"], "E · Cierre y recuperación"],
  ["26", "Intención cambiada", "La persona ya no desea realizar lo formulado.", "Cerrar o reformular.", "01 o 02", "Normalizar el cambio de idea como salida válida.", "Cambiar la intención no es un error.", "closed", "Cerrar ciclo", ["Editar intención"], "E · Cierre y recuperación"],
  ["27", "Permiso revocado", "Android retira un permiso durante el ciclo.", "Recuperar permiso o cerrar.", "03, 18 o 33", "Informar que la condición ya no puede observarse.", "El fallo pertenece al estado técnico del sistema.", "error", "Revisar permiso", ["Cambiar condición", "Cerrar ciclo"], "E · Cierre y recuperación"],
  ["28", "Restricción en segundo plano", "Android impide observar la condición con fiabilidad.", "Ajustar la restricción o cerrar.", "20, 18 o 33", "Transparentar el límite del segundo plano.", "No se afirma que la condición se haya evaluado.", "error", "Revisar restricción", ["Mantener en espera", "Cerrar ciclo"], "E · Cierre y recuperación"],
  ["29", "Pérdida de BLE o reconexión", "Se interrumpe el vínculo con el testigo.", "Reconectar, reintentar o cerrar.", "20, 23 o 33", "Diferenciar pérdida de enlace y cierre del ciclo.", "No se puede confirmar la entrega del pulso.", "error", "Reconectar", ["Reintentar", "Cerrar ciclo"], "E · Cierre y recuperación"],
  ["30", "Objeto movido", "Cambia el lugar cuya percepción fue probada.", "Repetir prueba antes de continuar.", "11", "Recordar que la ubicación es parte de la asociación.", "Un cambio de lugar invalida la prueba situada previa.", "error", "Reubicar y probar", ["Cerrar ciclo"], "E · Cierre y recuperación"],
  ["31", "Batería crítica", "La energía deja de asegurar la entrega.", "Cargar, desarmar o cerrar.", "10, 18 o 33", "Hacer visible un límite físico antes de prometer entrega.", "La energía disponible no asegura el siguiente pulso.", "error", "Cargar testigo", ["Desarmar ciclo", "Cerrar ciclo"], "E · Cierre y recuperación"],
  ["32", "Reinicio del objeto", "El testigo pierde temporalmente su estado.", "Verificar vínculo y rearmar explícitamente.", "07, 15 o 34", "Evitar que el reinicio produzca un armado automático.", "La relación debe volver a comprobarse.", "error", "Verificar vínculo", ["Repetir prueba", "Cerrar ciclo"], "E · Cierre y recuperación"],
  ["33", "Vencimiento sin activación", "Termina la vigencia sin una señal válida.", "Cerrar o preparar un nuevo ciclo.", "01 o 34", "Cerrar la ventana sin fabricar un resultado.", "No hubo pulso dentro de la vigencia.", "closed", "Cerrar ciclo", ["Preparar otro ciclo"], "E · Cierre y recuperación"],
  ["34", "Rearme explícito", "La persona desea repetir un ciclo terminado.", "Revisar y confirmar nuevamente.", "05", "Revisar la intención antes de armar otra vez.", "No existe rearme automático.", "review", "Continuar al armado", ["Volver al inicio"], "E · Cierre y recuperación"],
  ["35", "Eliminar configuración", "La persona decide borrar el ciclo o borrador.", "Confirmar eliminación o cancelar.", "01 o estado anterior", "Hacer irreversible solo la acción que la persona confirma.", "Cancelar conserva la configuración para revisarla después.", "closed", "Eliminar", ["Cancelar"], "E · Cierre y recuperación"],
];

export const coverageStates: CoverageState[] = coverageRows.map(
  ([id, title, trigger, primary, continuity, objective, error, visual, action, secondary, family]) => ({
    id,
    coverageState: id,
    interaction: family,
    title,
    short: trigger,
    slug: `cobertura-${id}-${title.toLowerCase().replace(/[^a-z0-9áéíóúñ]+/gi, "-").replace(/^-|-$/g, "")}`,
    objective,
    critical: trigger,
    action: primary,
    hierarchy: "Estado → información crítica → acción principal → salidas alternativas.",
    error,
    legend: `${trigger}\n${primary}\nLa continuidad documentada es ${continuity}.\nEl estado se presenta como hipótesis estructural, no como validación.`,
    visual,
    family,
    familyShort: familyInfo[family as keyof typeof familyInfo],
    trigger,
    continuity,
    primary: action,
    secondary,
  }),
);

export const coverageFamilies = Object.keys(familyInfo) as Array<keyof typeof familyInfo>;

export const getCoverageState = (id: string) =>
  coverageStates.find((state) => state.id === id) ?? coverageStates[0];

export const getDeliveryFrame = (id: string) =>
  deliveryFrames.find((frame) => frame.id === id) ?? deliveryFrames[0];
